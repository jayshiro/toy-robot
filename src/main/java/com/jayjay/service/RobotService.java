package com.jayjay.service;

import com.jayjay.model.Direction;

public interface RobotService {

    public void place(int newX, int newY, Direction newDirection);
    public void move();
    public void left();
    public void right();
    public String report();
}
