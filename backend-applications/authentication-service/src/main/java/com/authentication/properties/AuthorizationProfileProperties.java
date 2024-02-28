package com.authentication.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties
public class AuthorizationProfileProperties {

    @Value("${kafka.topic-name}")
    private String topicName;

    @Value("${kafka.bootstrap-servers}")
    private String bootstrapServers;
    @Value("${kafka.group-id}")
    private String groupId;

    @Value("${kafka.offset}")
    private String offset;
}
