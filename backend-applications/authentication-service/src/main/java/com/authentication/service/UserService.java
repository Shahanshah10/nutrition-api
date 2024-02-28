package com.authentication.service;

import com.authentication.consumer.KafkaMessageListener;
import com.authentication.dto.User;
import com.authentication.entity.UserInfo;
import com.authentication.repository.UserRepository;
import com.authentication.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserService {

    private final JwtUtil jwtUtil;

    private final UserRepository userRepository;

    private final UserDetailsService userDetailsService;



    public void addUserInMySQLDB(User user){
        UserInfo userInfo=new UserInfo();
        userInfo.setEmail(user.getEmail());
        userInfo.setPassword(user.getPassword());
        userInfo.setUsername(user.getUsername());
        userRepository.save(userInfo);
    }

    public String generateToken(String username) {
        return jwtUtil.generateToken(userDetailsService.loadUserByUsername(username));
    }

}
