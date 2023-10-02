package com.project.marsrover.service;

import com.project.marsrover.enums.Command;
import com.project.marsrover.enums.Direction;
import com.project.marsrover.model.MarsRover;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@Service
public class MarsRoverService {
    public final int[][] mars = new int[99][99];
    private Map<String, MarsRover> marsRovers = new HashMap<>();

    private Scanner scanner = new Scanner(System.in);

    public MarsRover deployRover() throws Exception {
        System.out.println("Please enter id of Mars Rover: ");
        String id = scanner.nextLine();

        if (marsRovers.containsKey(id)) {
            throw new Exception("Mars Rover " + id + " already exist");
        }

        System.out.println("Please enter the x coordinate of Mars Rover: ");
        int xCoordinate = Integer.parseInt(scanner.nextLine());

        System.out.println("Please enter the y coordinate of Mars Rover: ");
        int yCoordinate = Integer.parseInt(scanner.nextLine());

        if (xCoordinate >= 99 || yCoordinate >= 99 || xCoordinate < 0 || yCoordinate < 0) {
            throw new Exception("Out of Mars boundary.");
        }

        if (mars[xCoordinate][yCoordinate] == 1) {
            throw new Exception("Coordinates x: " + xCoordinate  + " y: " + yCoordinate + " is occupied by another rover");
        }

        System.out.println("Please enter the direction of Mars Rover: ");
        String directionStr = scanner.nextLine();
        Direction direction = Direction.getDirection(directionStr);

        MarsRover newMarsRover = new MarsRover(id, xCoordinate, yCoordinate, direction);
        marsRovers.put(id, newMarsRover);
        markCoordinateOccupied(xCoordinate, yCoordinate);

        return newMarsRover;
    }

    public void viewAll() {
        if (marsRovers.isEmpty()) {
            System.out.println("There are no mars rovers");
            return;
        }

        for (Map.Entry<String,MarsRover> entry : marsRovers.entrySet()) {
            MarsRover rover = entry.getValue();
            System.out.println("Mars rover Id: " + rover.getId());
            System.out.println("Mars rover " + rover.getId() + "'s direction " + rover.getDirection());
            System.out.println("Mars rover " + rover.getId() + "'s x coordinates " + rover.getXCoordinate());
            System.out.println("Mars rover " + rover.getId() + "'s y coordinates " + rover.getYCoordinate() + "\n");
        }
    }

    public void navigate() throws Exception {
        if (marsRovers.isEmpty()) {
            System.out.println("There are no mars rovers to navigate, please deploy a mar rover!");
            return;
        }

        System.out.println("Please enter id of Mars Rover to be navigated: ");
        String id = scanner.nextLine();
        if (!marsRovers.containsKey(id)) {
            throw new Exception("No Such Mars Rover");
        }

        MarsRover rover = marsRovers.get(id);
        System.out.println("Mars rover: " + rover.getId() + " has been selected");
        System.out.println("Please input your command");

        String[] commands = scanner.nextLine().split(",");

        try {
            for (String commandStr : commands) {
                Command command = Command.getCommand(commandStr);

                if (command == Command.BACKWARD || command == Command.FORWARD) {
                    rover.move(command, mars);
                } else {
                    rover.turn(command);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            markCoordinateOccupied(rover.getXCoordinate(), rover.getYCoordinate());
            System.out.println("Mars rover ID:" + rover.getId());
            System.out.println("Mars rover direction " + rover.getDirection());
            System.out.println("Mars rover x coordinates " + rover.getXCoordinate());
            System.out.println("Mars rover y coordinates " + rover.getYCoordinate());
        }
    }

    public void markCoordinateOccupied(int xCoordinate, int yCoordinate) {
        mars[xCoordinate][yCoordinate] = 1;
    }

}
