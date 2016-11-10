package com.jayjay;

import com.jayjay.model.ToyRobot;
import com.jayjay.service.CommandReader;
import com.jayjay.service.CommandReaderImpl;
import com.jayjay.service.RobotService;
import com.jayjay.service.RobotServiceImpl;

import java.util.Scanner;

public class RobotTool {
    public static void main (String [] args) {
        System.out.println("Welcome to Toy Robot Tool.\n" +
            "Valid case-sensitive commands are 'PLACE x,y,direction','LEFT','RIGHT','MOVE', and 'REPORT'.\n" +
            "Type in 'quit' to exit.");

        RobotService robotService = new RobotServiceImpl(new ToyRobot());
        CommandReader commandReader = new CommandReaderImpl(robotService);

        Scanner sc = new Scanner(System.in);
        String command = "";

        while(!command.equals("quit")) {
            command = sc.nextLine();
            commandReader.handle(command);
        }

        System.out.println("Program has terminated. Thank you for using Toy Robot Tool.");
    }
}
