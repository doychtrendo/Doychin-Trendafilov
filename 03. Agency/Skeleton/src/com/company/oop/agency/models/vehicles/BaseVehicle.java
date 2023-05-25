package com.company.oop.agency.models.vehicles;

public abstract class BaseVehicle {

    protected int passengerCapacity;
    protected double pricePerKilometer;
    protected VehicleType vehicleType;

    protected BaseVehicle(int passengerCapacity, double pricePerKilometer, VehicleType vehicleType) {
        this.passengerCapacity = passengerCapacity;
        this.pricePerKilometer = pricePerKilometer;
        this.vehicleType = vehicleType;
    }

    public String getAsString() {
        return String.format(
                "Passenger capacity: %d%n" +
                        "Price per kilometer: %.2f%n" +
                        "Vehicle type: %s%n",
                passengerCapacity, pricePerKilometer, vehicleType);
    }
}

