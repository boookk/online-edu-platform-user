package com.example.onlineeduplatformuser.domain;

public class User {

    private final int userId;
    private final int userType;
    private final String name;
    private final String email;
    private final String address;
    private final String phone;

    public User(int userId, int userType, String name, String email, String address,
            String phone) {
        this.userId = userId;
        this.userType = UserType.STUDENT.getValue();
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
    }

    public int getUserId() {
        return userId;
    }

    public int getUserType() {
        return userType;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

}
