package com.userprofile.service.dto;


import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo{
    private String username;
    private String email;
    private String password;
}

