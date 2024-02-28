package com.nutrition.external;


import com.nutrition.dto.Root;
import com.nutrition.exception.NutritionServiceException;
import com.nutrition.properties.NutritionProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.HashMap;
import java.util.Map;

import static com.nutrition.constants.NutritionConstants.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class ExternalNutritionApi {

    private final WebClient webClient;

    private final NutritionProperties nutritionProperties;

    public Root searchNutrients(String upc) {

        String nutritionApiUrl=nutritionProperties.getNutritionApiBaseUrl()
                .concat(nutritionProperties.getNutritionApiSearchEndPoint());
        Map<String,Object> params=new HashMap<>();
        params.put(UPC,upc);

        try {
            return webClient.get().uri(nutritionApiUrl,params)
                    .header(X_APP_ID, nutritionProperties.getXAppId())
                    .header(X_APP_KEY, nutritionProperties.getXAppKey())
                    .retrieve().bodyToMono(Root.class)
                    .block();
        }catch (Exception exception){
            log.error("Exception occurred while retrieving nutrients from nutrition-api : ",exception);
            throw new NutritionServiceException("Exception occurred while retrieving nutrients from nutrition-api : "+exception.getMessage());
        }



    }
}
