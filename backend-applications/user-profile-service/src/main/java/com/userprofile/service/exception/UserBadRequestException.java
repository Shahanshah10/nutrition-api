package com.userprofile.service.exception;

public class UserBadRequestException extends RuntimeException {

    public UserBadRequestException(String s) {
        super(s);
    }
}