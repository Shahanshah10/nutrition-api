package com.userprofile.service.service;

import com.userprofile.service.dto.UserInfo;
import com.userprofile.service.exception.UserBadRequestException;
import com.userprofile.service.model.User;
import com.userprofile.service.producer.KafkaMessageProducer;
import com.userprofile.service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import static com.userprofile.service.constants.UserProfileConstants.USER_SEQUENCE;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final KafkaMessageProducer kafkaMessageProducer;
    private final SequenceGeneratorService sequenceGeneratorService;
    public User addUser(User user){
        try {
            user.setUserId(sequenceGeneratorService.getSequenceNumber(USER_SEQUENCE));
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            User user1=userRepository.save(user);
            log.info("User created & saved in mongodb : " + user.getUsername());
            UserInfo userInfo=UserInfo.builder().username(user1.getUsername())
                    .email(user1.getEmail())
                    .password(user1.getPassword()).build();
            kafkaMessageProducer.sendCustomerToTopic(userInfo);
            return user1;

        } catch (Exception exception) {
            throw new UserBadRequestException("Exception occurred while saving data in db :  " + exception.getMessage());
        }
    }

}
