package com.jayjay.service;

import com.jayjay.model.Direction;
import com.jayjay.model.ToyRobot;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RobotServiceImplTest {
    private RobotService robotService;

    @Before
    public void setup () {
        robotService = new RobotServiceImpl(new ToyRobot());
    }

    @Test
    public void shouldPlaceRobotInsideArea() {
        robotService.place(1,4, Direction.EAST);
        assertEquals(robotService.report(), "1,4,EAST");
        robotService.place(3,1, Direction.NORTH);
        assertEquals(robotService.report(), "3,1,NORTH");
    }

    @Test
    public void shouldNotPlaceRobotOutsideArea() {
        robotService.place(-1,2,Direction.SOUTH);
        assertEquals(robotService.report(), "Robot is not yet placed.");
        robotService.place(3,5,Direction.NORTH);
        assertEquals(robotService.report(), "Robot is not yet placed.");
    }
}
