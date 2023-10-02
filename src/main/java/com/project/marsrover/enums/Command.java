package com.project.marsrover.enums;

public enum Command {
    FORWARD, BACKWARD, RIGHT, LEFT;

    public static Command getCommand(String command) throws Exception {
          switch (command.toLowerCase()) {
            case "f": return Command.FORWARD;
            case "b": return Command.BACKWARD;
            case "r": return Command.RIGHT;
            case "l": return Command.LEFT;
            default: throw new Exception("Invalid command");
        }
    }


}