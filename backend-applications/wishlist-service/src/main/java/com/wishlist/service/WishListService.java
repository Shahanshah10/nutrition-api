package com.wishlist.service;

import com.wishlist.dto.Food;
import com.wishlist.mapper.WishListMapper;
import com.wishlist.model.FoodData;
import com.wishlist.repository.WishListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.wishlist.constants.WishListConstants.SEQUENCE_NAME;

@Service
@RequiredArgsConstructor
public class WishListService {

    private final WishListMapper wishListMapper;
    private final WishListRepository wishListRepository;
    private final SequenceGeneratorService sequenceGeneratorService;

    public Food addFoodInWishlist(Food food){
        FoodData foodData1= wishListRepository.save(wishListMapper.toFoodData(food,sequenceGeneratorService.getSequenceNumber(SEQUENCE_NAME)));
        return wishListMapper.toFood(foodData1);

    }

    public List<Food> retrieveFoodByUsername(String username){
        return wishListMapper.toFoodList(wishListRepository.findFoodDataByUsername(username));
    }
    public void removeFoodFromWishlist(String nixItemId){
        wishListRepository.deleteByNixItemId(nixItemId);
    }
}
