package com.jayjay.model;

public enum Direction {
    NORTH,
    WEST,
    EAST,
    SOUTH;

    public static Direction findByName(String name) {
        for(Direction direction: values()) {
            if(direction.name().equals(name)) {
                return direction;
            }
        }
        return null;
    }
}
