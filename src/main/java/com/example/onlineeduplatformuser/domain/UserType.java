package com.example.onlineeduplatformuser.domain;

public enum UserType {
    STUDENT(1), TEACHER(2), ADVISOR(0);

    UserType(int typeValue) {
        this.value = typeValue;
    }

    private final int value;

    public int getValue() {
        return this.value;
    }
}
