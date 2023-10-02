package com.project.marsrover.enums;


public enum Direction {
    NORTH, SOUTH, EAST, WEST;

    public static Direction getDirection(String direction) throws Exception {
        switch (direction.toLowerCase()) {
            case "n": return Direction.NORTH;
            case "s": return Direction.SOUTH;
            case "e": return Direction.EAST;
            case "w": return Direction.WEST;
            default: throw new Exception("Invalid direction");
        }
    }
}
