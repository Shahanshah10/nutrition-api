package com.authentication.consumer;

import com.authentication.dto.User;
import com.authentication.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaMessageListener {

    private final UserService userService;

    @Retryable(
            maxAttempts = 3,
            backoff = @Backoff(delay = 1000, maxDelay = 3000)
    )
    @KafkaListener(topics = "user-profile-topic", containerFactory = "listenerContainerFactory")
    public void consumeUserMessage(User user) {
        log.info("Consume the user-message: {}", user);
        if (isValidUser(user)) {
            userService.addUserInMySQLDB(user);
        } else {
            log.error("Data is invalid/in-sufficient for processing in db: {}", user);
        }
    }

    private Boolean isValidUser(User user) {
        return Objects.nonNull(user) &&
                StringUtils.isNotBlank(user.getUsername()) &&
                StringUtils.isNotBlank(user.getPassword());
    }
}