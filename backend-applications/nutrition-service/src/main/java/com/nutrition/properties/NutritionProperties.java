package com.nutrition.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties
public class NutritionProperties {

    @Value("${external-nutrition-api.base-url}")
    private String nutritionApiBaseUrl;
    @Value("${external-nutrition-api.search-end-point}")
    private String nutritionApiSearchEndPoint;

    @Value("${external-nutrition-api.x-app-id}")
    private String xAppId;

    @Value("${external-nutrition-api.x-app-key}")
    private String xAppKey;
}
