package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.vehicles.contracts.Bus;

public class BusImpl extends BaseVehicle implements Bus {

    private static final int PASSENGER_MIN_VALUE = 10;
    private static final int PASSENGER_MAX_VALUE = 50;
    private static final double PRICE_MIN_VALUE = 0.1;
    private static final double PRICE_MAX_VALUE = 2.5;

    private int id;

    public BusImpl(int id, int passengerCapacity, double pricePerKilometer) {
        super(passengerCapacity, pricePerKilometer, VehicleType.LAND);
        setId(id);
        setPassengerCapacity(passengerCapacity);
        setPricePerKilometer(pricePerKilometer);
    }


    @Override
    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }


    @Override
    public VehicleType getType() {
        return vehicleType;
    }


    @Override
    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    private void setPassengerCapacity(int passengerCapacity) {
        if (passengerCapacity < PASSENGER_MIN_VALUE || passengerCapacity > PASSENGER_MAX_VALUE) {
            throw new IllegalArgumentException("A bus cannot have less than 10 passengers or more than 50 passengers.");
        }
        this.passengerCapacity = passengerCapacity;
    }


    @Override
    public double getPricePerKilometer() {
        return pricePerKilometer;
    }

    private void setPricePerKilometer(double pricePerKilometer) {
        if (pricePerKilometer < PRICE_MIN_VALUE || pricePerKilometer > PRICE_MAX_VALUE) {
            throw new IllegalArgumentException("A vehicle with a price per kilometer lower than $0.10 or higher than $2.50 cannot exist!s");
        }
        this.pricePerKilometer = pricePerKilometer;
    }


    @Override
    public String getAsString() {
        return String.format("Bus ----%n" +
                        "Passenger capacity: %d%n" +
                        "Price per kilometer: %.2f%n" +
                        "Vehicle type: %s%n",
                passengerCapacity, pricePerKilometer, vehicleType);
    }
}
