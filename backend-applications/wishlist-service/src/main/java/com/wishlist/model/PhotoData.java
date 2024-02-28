package com.wishlist.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhotoData {
    private String thumb;
    private Object highres;
    private boolean is_user_uploaded;
}