package com.sample.ecomm.hacker.parking;

import java.util.*;

// Enum to represent Vehicle Types
enum VehicleType {
    CAR, BIKE, TRUCK;
}

// Enum to represent Parking Spot Types
enum ParkingSpotType {
    SMALL, MEDIUM, LARGE;
}

// Enum to represent Ticket Status
enum TicketStatus {
    ACTIVE, PAID, LOST;
}

// Class representing a Parking Spot
class ParkingSpot {
    private String id;
    private ParkingSpotType type;
    private boolean isOccupied;

    public ParkingSpot(String id, ParkingSpotType type) {
        this.id = id;
        this.type = type;
        this.isOccupied = false;
    }

    public boolean isAvailable() {
        return !isOccupied;
    }

    public void occupySpot() {
        isOccupied = true;
    }

    public void freeSpot() {
        isOccupied = false;
    }

    public ParkingSpotType getType() {
        return type;
    }
}

// Abstract class for Vehicle
abstract class Vehicle {
    private String licensePlate;
    private VehicleType type;

    public Vehicle(String licensePlate, VehicleType type) {
        this.licensePlate = licensePlate;
        this.type = type;
    }

    public VehicleType getType() {
        return type;
    }
}

class Car extends Vehicle {
    public Car(String licensePlate) {
        super(licensePlate, VehicleType.CAR);
    }
}

class Bike extends Vehicle {
    public Bike(String licensePlate) {
        super(licensePlate, VehicleType.BIKE);
    }
}

class Truck extends Vehicle {
    public Truck(String licensePlate) {
        super(licensePlate, VehicleType.TRUCK);
    }
}

// Class representing Parking Ticket
class ParkingTicket {
    public String ticketId;
    private Vehicle vehicle;
    private Date entryTime;
    private Date exitTime;
    private TicketStatus status;

    public ParkingTicket(String ticketId, Vehicle vehicle) {
        this.ticketId = ticketId;
        this.vehicle = vehicle;
        this.entryTime = new Date();
        this.status = TicketStatus.ACTIVE;
    }

    public void closeTicket() {
        this.exitTime = new Date();
        this.status = TicketStatus.PAID;
    }
}

// Parking Lot Manager
class ParkingLot {
    private Map<ParkingSpotType, List<ParkingSpot>> availableSpots;
    private Map<String, ParkingTicket> activeTickets;

    public ParkingLot() {
        availableSpots = new HashMap<>();
        availableSpots.put(ParkingSpotType.SMALL, new ArrayList<>());
        availableSpots.put(ParkingSpotType.MEDIUM, new ArrayList<>());
        availableSpots.put(ParkingSpotType.LARGE, new ArrayList<>());
        activeTickets = new HashMap<>();
    }

    public void addParkingSpot(ParkingSpot spot) {
        availableSpots.get(spot.getType()).add(spot);
    }

    public ParkingTicket parkVehicle(Vehicle vehicle) {
        ParkingSpotType requiredType = getRequiredSpotType(vehicle);
        List<ParkingSpot> spots = availableSpots.get(requiredType);
        for (ParkingSpot spot : spots) {
            if (spot.isAvailable()) {
                spot.occupySpot();
                ParkingTicket ticket = new ParkingTicket(UUID.randomUUID().toString(), vehicle);
                activeTickets.put(ticket.ticketId, ticket);
                return ticket;
            }
        }
        throw new RuntimeException("No available parking spot for vehicle type: " + vehicle.getType());
    }

    public void exitVehicle(String ticketId) {
        ParkingTicket ticket = activeTickets.get(ticketId);
        if (ticket != null) {
            ticket.closeTicket();
            activeTickets.remove(ticketId);
        }
    }

    private ParkingSpotType getRequiredSpotType(Vehicle vehicle) {
        switch (vehicle.getType()) {
            case CAR: return ParkingSpotType.MEDIUM;
            case BIKE: return ParkingSpotType.SMALL;
            case TRUCK: return ParkingSpotType.LARGE;
            default: throw new IllegalArgumentException("Unknown vehicle type");
        }
    }
}

public class AutomatedParkingLotSystem {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.addParkingSpot(new ParkingSpot("S1", ParkingSpotType.SMALL));
        parkingLot.addParkingSpot(new ParkingSpot("M1", ParkingSpotType.MEDIUM));
        parkingLot.addParkingSpot(new ParkingSpot("L1", ParkingSpotType.LARGE));

        Vehicle car = new Car("ABC123");
        ParkingTicket ticket = parkingLot.parkVehicle(car);
        System.out.println("Vehicle parked with ticket ID: " + ticket);

        parkingLot.exitVehicle(ticket.ticketId);
        System.out.println("Vehicle exited");
    }
}
