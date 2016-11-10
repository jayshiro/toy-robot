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

    @Test
    public void shouldNotAllowRobotMovementsWhenNotYetPlaced() {
        robotService.move();
        robotService.left();
        robotService.move();
        assertEquals(robotService.report(), "Robot is not yet placed.");
    }

    @Test
    public void shouldMoveRobotProperly() {
        robotService.place(4,4,Direction.SOUTH);
        robotService.move();
        assertEquals(robotService.report(), "4,3,SOUTH");
    }

    @Test
    public void shouldChangeDirectionsProperly() {
        robotService.place(2,2,Direction.WEST);
        robotService.left();
        assertEquals(robotService.report(), "2,2,SOUTH");
        robotService.right();
        assertEquals(robotService.report(), "2,2,WEST");
    }

    @Test
    public void shouldMoveProperlyAfterChangingDirections() {
        robotService.place(1,1,Direction.EAST);
        robotService.right();
        robotService.move();
        assertEquals(robotService.report(), "1,0,SOUTH");
        robotService.left();
        robotService.move();
        assertEquals(robotService.report(), "2,0,EAST");
    }

    @Test
    public void shouldBeAbleToPlaceMoreThanOnce() {
        robotService.place(0,0,Direction.WEST);
        assertEquals(robotService.report(), "0,0,WEST");
        robotService.place(3,4,Direction.SOUTH);
        assertEquals(robotService.report(), "3,4,SOUTH");
    }

    @Test
    public void shouldNotMovePastArea() {
        robotService.place(1,3,Direction.EAST);
        robotService.left();
        robotService.move();
        robotService.move();
        robotService.move();
        assertEquals(robotService.report(), "1,4,NORTH");
    }
}
