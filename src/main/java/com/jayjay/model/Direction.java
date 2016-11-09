package com.jayjay.model;

public enum Direction {
    NORTH("North"),
    WEST("West"),
    EAST("East"),
    SOUTH("South");

    private String displayName;
    Direction(String displayName){
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
