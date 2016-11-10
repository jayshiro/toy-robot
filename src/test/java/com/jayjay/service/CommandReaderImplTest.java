package com.jayjay.service;

import com.jayjay.model.ToyRobot;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CommandReaderImplTest {

    private CommandReader commandReader;
    private RobotService robotService;

    @Before
    public void setup() {
        robotService = new RobotServiceImpl(new ToyRobot());
        commandReader = new CommandReaderImpl(robotService);
    }

    @Test
    public void shouldBeInvalidIfCommandIsEmpty() {
        assertFalse(commandReader.isValid(""));
    }

    @Test
    public void shouldBeInvalidIfCommandIsTooLong() {
        assertFalse(commandReader.isValid("PLACE 1,2,NORTH x"));
    }

    @Test
    public void shouldBeInvalidIfCommandIsNotInsideEnum() {
        assertFalse(commandReader.isValid("REMOVE"));
        assertFalse(commandReader.isValid("PUT"));
    }

    @Test
    public void shouldBeInvalidIfCommandIsNotPlaceWhenInputHasParameters() {
        assertFalse(commandReader.isValid("MOVE 1,2,NORTH"));
        assertFalse(commandReader.isValid("LEFT 3,4,SOUTH"));
    }

    @Test
    public void shouldBeInvalidIfPlaceDoesNotHaveThreeParameters() {
        assertFalse(commandReader.isValid("PLACE 1,2"));
        assertFalse(commandReader.isValid("PLACE 4,3,NORTH,WEST"));
    }

    @Test
    public void shouldBeInvalidIfFirstTwoPlaceParametersAreNotIntegers() {
        assertFalse(commandReader.isValid("PLACE a,2,WEST"));
        assertFalse(commandReader.isValid("PLACE x,y,SOUTH"));
    }

    @Test
    public void shouldBeInvalidIfDirectionIsNonExistent() {
        assertFalse(commandReader.isValid("PLACE 3,4,THERE"));
        assertFalse(commandReader.isValid("PLACE 4,1,HEY"));
    }

    @Test
    public void shouldBeValidIfInputHasCorrectValues() {
        assertTrue(commandReader.isValid("PLACE 1,3,NORTH"));
        assertTrue(commandReader.isValid("LEFT"));
        assertTrue(commandReader.isValid("RIGHT"));
        assertTrue(commandReader.isValid("MOVE"));
        assertTrue(commandReader.isValid("REPORT"));
    }
}
