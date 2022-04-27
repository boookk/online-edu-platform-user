package com.example.onlineeduplatformuser.model;

public enum UserType {
    STUDENT(1), TEACHER(2), ADVISOR(9);

    UserType(int typeValue) {
        this.value = String.valueOf(typeValue);
    }

    private final String value;

    public String getValue() {
        return this.value;
    }
}
