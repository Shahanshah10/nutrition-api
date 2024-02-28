package com.userprofile.service.producer;

import com.userprofile.service.dto.UserInfo;
import com.userprofile.service.properties.UserProfileProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaMessageProducer {

    private final KafkaTemplate<String, UserInfo> kafkaTemplate;
    private final UserProfileProperties userProfileProperties;

    public void sendCustomerToTopic(UserInfo userInfo) {
        CompletableFuture<SendResult<String, UserInfo>> completableFuture = kafkaTemplate.send(userProfileProperties.getTopicName(), userInfo);
        completableFuture.whenComplete((result, ex) -> {
            if (ex == null) {
                log.info("Sent user info :{} with offset: {} && partition: {}", result.getProducerRecord().value(),
                        result.getRecordMetadata().offset(), result.getRecordMetadata().partition());
            } else {
                log.error("Unable to sent message :{} due to exception :{}", userInfo, ex.getMessage());
            }
        });
    }
}
        