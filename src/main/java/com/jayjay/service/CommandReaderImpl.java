package com.jayjay.service;

import com.jayjay.model.Command;
import com.jayjay.model.Direction;

public class CommandReaderImpl implements CommandReader{

    private RobotService robotService;

    public CommandReaderImpl(RobotService robotService) {
        this.robotService = robotService;
    }

    @Override
    public boolean isValid(String command) {
        if(command == null || command.length() <= 0) {
            return false;
        }

        String[] commandArr = command.split(" ");
        if(commandArr.length > 2) {
            return false;
        }

        if(Command.findByName(commandArr[0]) == null) {
            return false;
        }

        if(commandArr.length == 2) {
            return isValidPlace(commandArr[0], commandArr[1]);
        }

        return true;
    }

    private boolean isValidPlace(String commandName, String params) {
        if(!commandName.equals(Command.PLACE.name())) {
            return false;
        }

        String[] paramsArr = params.split(",");
        if(paramsArr.length != 3) {
            return false;
        }

        try {
            Integer.parseInt(paramsArr[0]);
            Integer.parseInt(paramsArr[1]);
        } catch(NumberFormatException nfe) {
            return false;
        }

        if(Direction.findByName(paramsArr[2]) == null) {
            return false;
        }

        return true;
    }

    @Override
    public void handle(String input) {

        if(isValid(input)) {
            String[] commandArr = input.split(" ");
            Command command = Command.findByName(commandArr[0]);

            switch (command) {
                case PLACE:
                    String[] paramsArr = commandArr[1].split(",");
                    robotService.place(Integer.parseInt(paramsArr[0]), Integer.parseInt(paramsArr[1]),
                            Direction.findByName(paramsArr[2]));
                    break;
                case LEFT:
                    robotService.left();
                    break;
                case RIGHT:
                    robotService.right();
                    break;
                case MOVE:
                    robotService.move();
                    break;
                case REPORT:
                    robotService.report();
                    break;
            }
        }
    }
}
