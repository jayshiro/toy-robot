package com.jayjay.model;

public class ToyRobot {
    private int x;
    private int y;
    private Direction direction;
    private boolean isPlaced;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void addX(int val) {
        x += val;
    }

    public void addY(int val) {
        y += val;
    }

    public String toString() {
        return x + "," + y + "," + direction.name();
    }

    public boolean isPlaced() {
        return isPlaced;
    }

    public void setPlaced(boolean isPlaced) {
        this.isPlaced = isPlaced;
    }
}
