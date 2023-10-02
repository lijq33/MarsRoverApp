
# Mars Rover App

# About this application

This is a simple springboot application that allows you to deploy and command your rover on mars.

## Assumptions made
1. Rovers are not allows to move out of mars' predefined boundary of (99,99).
2. Multiple rovers can be deployed and each rover have a unique id - you will need to select the rover after deploying in order to navigate it.
3. At anypoint in time, you can select other rovers and navigate with it.
4. Rovers will stop and end further commands if the next command results in collision
5. Commands to navigate the rover must only be comma separated

## Sample command to navigate rover:
f,f,r,b,l,f

### Commands:
1. **f** - Moves the rover forward
2. **b** - Moves the rover backward
3. **l** - Turns the rover left
4. **r** - Turns the rover right

## How to use this application
1. Start spring boot application by running `MarsRoverApplication.java`
2. Follow the prompt that shows up.
3. deploy rover (1)
4. display rover (2)
5. navigate rover (3)
