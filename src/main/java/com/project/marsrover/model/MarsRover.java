package com.project.marsrover.model;

import com.project.marsrover.enums.Command;
import com.project.marsrover.enums.Direction;
import lombok.Getter;
import lombok.Setter;

public class MarsRover {

    @Getter
    @Setter
    private String id;

    @Getter
    @Setter
    private int xCoordinate;

    @Getter
    @Setter
    private int yCoordinate;

    @Getter
    @Setter
    private Direction direction;

    public MarsRover(String id, int xCoordinate, int yCoordinate, Direction direction) {
        this.id = id;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.direction = direction;
    }

    public void turn(Command command) {
        switch (this.getDirection()) {
            case NORTH: {
                if (command == Command.LEFT) {
                    this.setDirection(Direction.WEST);
                } else {
                    this.setDirection(Direction.EAST);
                }
            }
            break;
            case SOUTH: {
                if (command == Command.LEFT) {
                    this.setDirection(Direction.EAST);
                } else {
                    this.setDirection(Direction.WEST);
                }
            }
            break;
            case EAST: {
                if (command == Command.LEFT) {
                    this.setDirection(Direction.NORTH);
                } else {
                    this.setDirection(Direction.SOUTH);
                }
            }
            break;
            case WEST: {
                if (command == Command.LEFT) {
                    this.setDirection(Direction.SOUTH);
                } else {
                    this.setDirection(Direction.NORTH);
                }
            }
            break;
        }
    }

    public void move(Command command, int[][] mars) throws Exception {
        mars[this.getXCoordinate()][this.getYCoordinate()] = 0;

        switch (this.getDirection()) {
            case NORTH: {
                if (command == Command.FORWARD) {
                    this.updateCoordinates(mars, this.getXCoordinate(), this.getYCoordinate() + 1);
                } else {
                    this.updateCoordinates(mars, this.getXCoordinate(), this.getYCoordinate() - 1);
                }
            }
            break;
            case SOUTH: {
                if (command == Command.FORWARD) {
                    this.updateCoordinates(mars, this.getXCoordinate(), this.getYCoordinate() - 1);
                } else {
                    this.updateCoordinates(mars, this.getXCoordinate(), this.getYCoordinate() + 1);
                }
            }
            break;
            case EAST: {
                if (command == Command.FORWARD) {
                    this.updateCoordinates(mars, this.getXCoordinate() + 1, this.getYCoordinate());
                } else {
                    this.updateCoordinates(mars, this.getXCoordinate() - 1, this.getYCoordinate());
                }
            }
            break;
            case WEST: {
                if (command == Command.FORWARD) {
                    this.updateCoordinates(mars, this.getXCoordinate() - 1, this.getYCoordinate());
                } else {
                    this.updateCoordinates(mars, this.getXCoordinate() + 1, this.getYCoordinate());
                }
            }
            break;
        }
    }

    public void updateCoordinates(int[][] mars, int xCoordinate, int yCoordinate) throws Exception {
        if (xCoordinate >= 99 || yCoordinate >= 99 || xCoordinate < 0 || yCoordinate < 0) {
            throw new Exception("Out of boundary.");
        }
        if (mars[xCoordinate][yCoordinate] != 0) {
            throw new Exception("Collision detected");
        }
        this.setXCoordinate(xCoordinate);
        this.setYCoordinate(yCoordinate);
    }
}
