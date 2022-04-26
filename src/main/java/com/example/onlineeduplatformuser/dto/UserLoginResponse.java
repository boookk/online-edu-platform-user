package com.example.onlineeduplatformuser.dto;

public class UserLoginResponse {
    private final String userType;

    public UserLoginResponse(String userType) {

        this.userType = userType;
    }

    public String getUserType() {
        return userType;
    }
}
