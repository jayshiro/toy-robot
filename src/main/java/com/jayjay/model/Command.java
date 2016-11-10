package com.jayjay.model;

public enum Command {
    PLACE,
    MOVE,
    LEFT,
    RIGHT,
    REPORT;

    public static Command findByName(String name) {
        for(Command command : values()) {
            if(command.name().equals(name)) {
                return command;
            }
        }
        return null;
    }
}
