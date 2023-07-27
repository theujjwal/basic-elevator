package org.example;

import java.util.ArrayList;
import java.util.List;

enum Direction {
    UP, DOWN, IDLE
}

class Elevator {
    private int currentFloor;
    private Direction direction;
    private List<Integer> stopFloorList;

    public Elevator() {
        this.currentFloor = 1;
        this.direction = Direction.IDLE;
        this.stopFloorList = new ArrayList<>();
    }

    public void goTo(int floor) {
        if(!this.stopFloorList.isEmpty()){
            if (floor > currentFloor) {
                direction = Direction.UP;
            } else if (floor < currentFloor) {
                direction = Direction.DOWN;
            } else {
                direction = Direction.IDLE;
            }

            while (currentFloor != floor) {
                move();
            }

            direction = Direction.IDLE;
            stopFloorList.remove(Integer.valueOf(floor));
        }

    }

    public void addStopFloor(int floor) {
        if (!stopFloorList.contains(floor)) {
            stopFloorList.add(floor);
        }
    }

    private void move() {
        if (direction == Direction.UP) {
            currentFloor++;
        } else if (direction == Direction.DOWN) {
            currentFloor--;
        }

        System.out.println("Elevator is at floor: " + currentFloor);

        if (stopFloorList.contains(currentFloor)) {
            stopFloorList.remove(Integer.valueOf(currentFloor));
            System.out.println("Elevator stopped at floor: " + currentFloor);
        }
    }
}





public class Main {
    public static void main(String[] args) {
        Elevator elevator = new Elevator();

        elevator.addStopFloor(5);
        elevator.addStopFloor(3);

        // Elevator movement
        elevator.goTo(5);
        elevator.goTo(3);
        elevator.addStopFloor(4);
        elevator.goTo(4);

    }
}

