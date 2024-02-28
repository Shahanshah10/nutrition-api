package com.userprofile.service.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "users")
public class User {

    @Id
    private long userId;
    @Indexed(unique = true)
    private String username;
    @NonNull
    private String email;
    @NonNull
    private String password;
    private Double height;
    private Double weight;
    private int age;
    private String gender;
}
