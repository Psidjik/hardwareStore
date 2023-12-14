package com.example.demo.models.enums;

public enum Role {
CLIENT(0) ,ADMIN(1);

    private int value;

    Role(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
