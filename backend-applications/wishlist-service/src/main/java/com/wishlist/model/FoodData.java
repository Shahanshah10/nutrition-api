package com.wishlist.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "food")
public class FoodData {

    @Id
    private long id;
    private String username;
    private String food_name;
    private String brand_name;
    private int serving_qty;
    private String serving_unit;
    private int serving_weight_grams;
    private int nf_metric_qty;
    private String nf_metric_uom;
    private int nf_calories;
    private int nf_total_fat;
    private Object nf_saturated_fat;
    private Object nf_cholesterol;
    private int nf_sodium;
    private int nf_total_carbohydrate;
    private Object nf_dietary_fiber;
    private Object nf_sugars;
    private int nf_protein;
    private Object nf_potassium;
    private Object nf_p;
    private List<FullNutrientData> full_nutrients;
    private String nix_brand_name;
    private String nix_brand_id;
    private String nix_item_name;
    private String nix_item_id;
    private int source;
    private Object ndb_no;
    private Object tags;
    private Object alt_measures;
    private Object lat;
    private Object lng;
    private PhotoData photoData;
    private Object note;
    private Object class_code;
    private Object brick_code;
    private Object tag_id;
    private Date updated_at;
    private String nf_ingredient_statement;
}