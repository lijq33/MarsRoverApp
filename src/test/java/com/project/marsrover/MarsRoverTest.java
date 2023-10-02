package com.project.marsrover;

import com.project.marsrover.enums.Command;
import com.project.marsrover.enums.Direction;
import com.project.marsrover.model.MarsRover;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MarsRoverTest {

    private MarsRover marsRover;

    @Before
    public void setUp() {
        marsRover = new MarsRover("Rover1", 1, 1, Direction.NORTH);
    }

    @Test
    public void testTurnLeft() {
        marsRover.turn(Command.LEFT);
        assertEquals(Direction.WEST, marsRover.getDirection());
    }

    @Test
    public void testTurnRight() {
        marsRover.turn(Command.RIGHT);
        assertEquals(Direction.EAST, marsRover.getDirection());
    }

    @Test
    public void testMoveForward() throws Exception {
        marsRover.move(Command.FORWARD, new int[99][99]);
        assertEquals(2, marsRover.getYCoordinate());
    }

    @Test
    public void testMoveBackward() throws Exception {
        marsRover.move(Command.BACKWARD, new int[99][99]);
        assertEquals(0, marsRover.getYCoordinate());
    }

    @Test(expected = Exception.class)
    public void testMoveOutOfBound() throws Exception {
        int[][] mars = new int[99][99];
        marsRover.move(Command.BACKWARD, mars);
        marsRover.move(Command.BACKWARD, mars);
    }
}
