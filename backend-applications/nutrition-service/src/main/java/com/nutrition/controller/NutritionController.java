package com.nutrition.controller;

import com.nutrition.dto.Root;
import com.nutrition.external.ExternalNutritionApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

import static com.nutrition.constants.NutritionConstants.BASE_URL;
import static com.nutrition.constants.NutritionConstants.GET_NUTRITION_URL;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = BASE_URL)
public class NutritionController {

    private final ExternalNutritionApi externalNutritionApi;

    @GetMapping(value=GET_NUTRITION_URL)
    public ResponseEntity<Root> searchNutrients(@Param("upc") String upc) {
        log.info("Enter into searching nutrients with upc :{}", upc);
        Root root = externalNutritionApi.searchNutrients(upc);
        log.info("Exiting from searching nutrients with upc :{}", upc);
        return Objects.nonNull(root) ? ResponseEntity.status(HttpStatus.OK).body(root) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();

    }
}
