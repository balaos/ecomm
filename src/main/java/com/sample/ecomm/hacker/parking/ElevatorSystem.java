package com.sample.ecomm.hacker.parking;

import java.util.*;

// Enum to represent direction
enum Direction {
    UP, DOWN, IDLE;
}

// Enum to represent Elevator State
enum ElevatorState {
    MOVING, STOPPED, IDLE;
}

// Class representing an Elevator Request
class ElevatorRequest {
    private int floor;
    private Direction direction;

    public ElevatorRequest(int floor, Direction direction) {
        this.floor = floor;
        this.direction = direction;
    }

    public int getFloor() {
        return floor;
    }

    public Direction getDirection() {
        return direction;
    }
}

// Class representing an Elevator
class Elevator {
    private int id;
    private int currentFloor;
    private Direction direction;
    private ElevatorState state;
    private PriorityQueue<Integer> upQueue;
    private PriorityQueue<Integer> downQueue;

    public Elevator(int id) {
        this.id = id;
        this.currentFloor = 0; // Default ground floor
        this.direction = Direction.IDLE;
        this.state = ElevatorState.IDLE;
        this.upQueue = new PriorityQueue<>();
        this.downQueue = new PriorityQueue<>(Collections.reverseOrder());
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public boolean isIdle() {
        return state == ElevatorState.IDLE;
    }

    public void addRequest(int floor) {
        if (floor > currentFloor) {
            upQueue.add(floor);
            direction = Direction.UP;
        } else {
            downQueue.add(floor);
            direction = Direction.DOWN;
        }
        processNextRequest();
    }

    public void processNextRequest() {
        if (!upQueue.isEmpty() && direction == Direction.UP) {
            moveToFloor(upQueue.poll());
        } else if (!downQueue.isEmpty() && direction == Direction.DOWN) {
            moveToFloor(downQueue.poll());
        } else {
            direction = Direction.IDLE;
            state = ElevatorState.IDLE;
        }
    }

    private void moveToFloor(int floor) {
        System.out.println("Elevator " + id + " moving from " + currentFloor + " to " + floor);
        currentFloor = floor;
        state = ElevatorState.STOPPED;
        System.out.println("Elevator " + id + " stopped at floor " + floor);
        processNextRequest();
    }
}

// Elevator Controller to handle multiple elevators
class ElevatorController {
    private List<Elevator> elevators;

    public ElevatorController(int numElevators) {
        elevators = new ArrayList<>();
        for (int i = 1; i <= numElevators; i++) {
            elevators.add(new Elevator(i));
        }
    }

    public void requestElevator(int floor, Direction direction) {
        Elevator bestElevator = findBestElevator(floor, direction);
        if (bestElevator != null) {
            bestElevator.addRequest(floor);
        } else {
            System.out.println("No available elevator for request at floor " + floor);
        }
    }

    private Elevator findBestElevator(int floor, Direction direction) {
        Elevator bestElevator = null;
        int minDistance = Integer.MAX_VALUE;
        for (Elevator elevator : elevators) {
            int distance = Math.abs(elevator.getCurrentFloor() - floor);
            if (elevator.isIdle() || (elevator.getCurrentFloor() <= floor && direction == Direction.UP)) {
                if (distance < minDistance) {
                    minDistance = distance;
                    bestElevator = elevator;
                }
            }
        }
        return bestElevator;
    }
}

public class ElevatorSystem {
    public static void main(String[] args) {
        ElevatorController controller = new ElevatorController(3);
        controller.requestElevator(5, Direction.UP);
        controller.requestElevator(2, Direction.DOWN);
        controller.requestElevator(8, Direction.UP);
    }
}
