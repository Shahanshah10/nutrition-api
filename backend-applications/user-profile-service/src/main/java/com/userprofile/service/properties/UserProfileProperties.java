package com.userprofile.service.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties
public class UserProfileProperties {

    @Value("${kafka.topic-name}")
    private String topicName;

    @Value("${kafka.bootstrap-servers}")
    private String bootstrapServers;
}
