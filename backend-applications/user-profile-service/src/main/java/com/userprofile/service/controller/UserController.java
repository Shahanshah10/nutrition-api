package com.userprofile.service.controller;

import com.userprofile.service.constants.UserProfileConstants;
import com.userprofile.service.model.User;
import com.userprofile.service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.userprofile.service.constants.UserProfileConstants.ADD_USER_URL;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = UserProfileConstants.USER_PROFILE_BASE_URL)
public class UserController {

    private final UserService userservice;

    @PostMapping(value = ADD_USER_URL)
    public ResponseEntity<User> addUser(@RequestBody User user){;
        return new ResponseEntity<>(userservice.addUser(user), HttpStatus.CREATED);
    }
}
