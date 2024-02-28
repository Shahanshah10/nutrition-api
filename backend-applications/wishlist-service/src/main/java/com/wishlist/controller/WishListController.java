package com.wishlist.controller;

import com.wishlist.config.AuthenticationInterceptor;
import com.wishlist.dto.Food;
import com.wishlist.service.WishListService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

import static com.wishlist.constants.WishListConstants.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = WISHLIST_BASE_URL)
public class WishListController {

    private final WishListService wishListService;
    private final AuthenticationInterceptor authenticationInterceptor;

    @PostMapping(value = WISHLIST_ADD_URL)
    public ResponseEntity<Food> addFoodInWishlist(@RequestBody Food food) {
        log.info("Enter into addFoodInWishlist with nix_item_id : {}", food.getNix_item_id());
        food.setUsername(authenticationInterceptor.retrieveUsername());
        Food food1 = wishListService.addFoodInWishlist(food);
        log.info("Existing from addFoodInWishlist with nix_item_id : {}", food.getNix_item_id());
        return Objects.nonNull(food1) ? ResponseEntity.status(HttpStatus.CREATED).body(food1) : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

    }

    @GetMapping(value = RETRIEVE_WISHLIST_URL)
    public ResponseEntity<List<Food>> retrieveFoodByUsername() {
        String username = authenticationInterceptor.retrieveUsername();
        log.info("Enter into retrieveFoodByUsername with username : {}", username);
        List<Food> foodList = wishListService.retrieveFoodByUsername(username);
        log.info("Existing from retrieveFoodByUsername with username : {}", username);
        return CollectionUtils.isNotEmpty(foodList) ? ResponseEntity.status(HttpStatus.CREATED).body(foodList) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();

    }

    @DeleteMapping(value = REMOVE_WISHLIST_URL)
    public ResponseEntity<String> removeFoodFromWishlist(@RequestParam("nixItemId") String nixItemId) {
        log.info("Enter into removeFoodFromWishlist with nixItemId : {}", nixItemId);
        wishListService.removeFoodFromWishlist(nixItemId);
        log.info("Existing from removeFoodFromWishlist with nixItemId : {}", nixItemId);
        return ResponseEntity.status(HttpStatus.OK).body("Successfully removed from wishlist " + nixItemId);
    }

}
