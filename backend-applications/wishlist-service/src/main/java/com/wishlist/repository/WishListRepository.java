package com.wishlist.repository;

import com.wishlist.model.FoodData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WishListRepository extends MongoRepository<FoodData,Long> {

    @Query(value = "{'nix_item_id' : ?0}", delete = true)
    void deleteByNixItemId(String nix_item_id);

    @Query(value = "{username: ?0}")
    List<FoodData> findFoodDataByUsername(String username);
}
