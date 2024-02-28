package com.wishlist.mapper;

import com.wishlist.dto.Food;
import com.wishlist.model.FoodData;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface WishListMapper {

    List<Food> toFoodList(List<FoodData> foodDataList);


    @Mapping(target = "id",source = "id")
    FoodData toFoodData(Food food,Integer id);

    Food toFood(FoodData foodData);

}
