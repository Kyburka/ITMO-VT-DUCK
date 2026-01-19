package Enums;

public enum BowlType {
    DEEP("Глубокая"),
    FLAT("Плоская"),
    SMALL("Маленькая");

    private final String description;

    BowlType(String description) {
        this.description = description;
    }
}
