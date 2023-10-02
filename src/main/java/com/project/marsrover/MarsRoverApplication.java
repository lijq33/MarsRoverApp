package com.project.marsrover;
import com.project.marsrover.model.MarsRover;
import com.project.marsrover.service.MarsRoverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class MarsRoverApplication   implements CommandLineRunner {

    @Autowired
    MarsRoverService marsRoverService;

    public static void main(String[] args) {
        SpringApplication.run(MarsRoverApplication.class, args);
    }

    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        //Select menu
        do {
            System.out.println("Welcome to Mars Rover App");
            mainMenu();

            choice = scanner.nextInt();
            switch(choice) {
                case 1:
                    System.out.println("Deploying new mars rover");
                    try {
                        MarsRover marsRover = marsRoverService.deployRover();
                        System.out.println("Mars rover " + marsRover.getId() + " successfully deployed!");
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;
                case 2:
                    System.out.println("Displaying all mars rovers");
                     marsRoverService.viewAll();
                    break;
                case 3:
                    System.out.println("Navigating mars rovers");
                    try {
                        marsRoverService.navigate();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;
                case 4:
                    System.out.println("Exiting. Goodbye!");
                    break;
                default:
                    System.out.println("Wrong Input. Please input from 1 - 4.");
                    break;
            }
        } while(choice != 4);
    }

    public static void mainMenu(){
        System.out.println(" =====================================");
        System.out.println(" *         Mars Rover System         *");
        System.out.println(" =====================================");
        System.out.println(" * 1. Deploy Rover                   *");
        System.out.println(" * 2. Display Rover                  *");
        System.out.println(" * 3. Navigate Rover                 *");
        System.out.println(" * 4. Quit                           *");
    }


}
