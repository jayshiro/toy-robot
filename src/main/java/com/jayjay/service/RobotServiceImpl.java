package com.jayjay.service;

import com.jayjay.model.Direction;
import com.jayjay.model.ToyRobot;

public class RobotServiceImpl implements RobotService{

    private static final String MSG_ROBOT_NOT_PLACED = "Robot is not yet placed.";

    private ToyRobot robot;

    public RobotServiceImpl(ToyRobot robot) {
        this.robot = robot;
    }

    @Override
    public void place(int newX, int newY, Direction newDirection){
        if(!willFallOver(newX, newY)) {
            robot.setX(newX);
            robot.setY(newY);
            robot.setDirection(newDirection);
            robot.setPlaced(true);
        }
    }

    @Override
    public void move() {
        if(!robot.isPlaced()) {
            return;
        }

        switch (robot.getDirection()) {
            case NORTH:
                if(!willFallOver(robot.getX(),robot.getY()+1)) {
                    robot.addY(1);
                }
                break;
            case WEST:
                if(!willFallOver(robot.getX()-1,robot.getY())) {
                    robot.addX(-1);
                }
                break;
            case EAST:
                if(!willFallOver(robot.getX()+1,robot.getY())) {
                    robot.addX(1);
                }
                break;
            case SOUTH:
                if(!willFallOver(robot.getX(),robot.getY()-1)) {
                    robot.addY(-1);
                }
                break;
        }
    }

    @Override
    public void left() {
        if(!robot.isPlaced()) {
            return;
        }

        switch (robot.getDirection()) {
            case NORTH:
                robot.setDirection(Direction.WEST);
                break;
            case WEST:
                robot.setDirection(Direction.SOUTH);
                break;
            case EAST:
                robot.setDirection(Direction.NORTH);
                break;
            case SOUTH:
                robot.setDirection(Direction.EAST);
                break;
        }
    }

    @Override
    public void right() {
        if(!robot.isPlaced()) {
            return;
        }

        switch (robot.getDirection()) {
            case NORTH:
                robot.setDirection(Direction.EAST);
                break;
            case WEST:
                robot.setDirection(Direction.NORTH);
                break;
            case EAST:
                robot.setDirection(Direction.SOUTH);
                break;
            case SOUTH:
                robot.setDirection(Direction.WEST);
                break;
        }
    }

    @Override
    public String report() {
        String output = robot.isPlaced() ? robot.toString() : MSG_ROBOT_NOT_PLACED;
        System.out.println(output);
        return output;
    }

    private boolean willFallOver(int newX, int newY) {
        return ((newX > 4 || newX < 0) || (newY > 4 || newY < 0)) ? true : false;
    }}
