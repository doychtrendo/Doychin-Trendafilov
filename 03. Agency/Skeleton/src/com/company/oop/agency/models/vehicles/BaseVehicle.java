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
}

