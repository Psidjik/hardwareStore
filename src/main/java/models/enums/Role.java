package models.enums;

public enum Role {
    MODERATOR(0), CLIENT(1) ,ADMIN(2);

    private int value;

    Role(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
