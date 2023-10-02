
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
f – Move forward 1 coordinate in the current direction
b – Move backward 1 coordinate in the current direction
r – Rotate 90 degree clock-wise from current direction
l – Rotate 90 degree anti clock-wise from current direction

## How to use this application
1. Start spring boot application by running `MarsRoverApplication.java`
2. Enter accordingly to the prompt

