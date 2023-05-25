package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.vehicles.contracts.Train;

public class TrainImpl extends BaseVehicle implements Train {

    private static final int PASSENGER_MIN_VALUE = 30;
    private static final int PASSENGER_MAX_VALUE = 150;
    private static final int CARTS_MIN_VALUE = 1;
    private static final int CARTS_MAX_VALUE = 15;
    private static final double PRICE_MIN_VALUE = 0.1;
    private static final double PRICE_MAX_VALUE = 2.5;

    private int id;
    private int carts;

    public TrainImpl(int id, int passengerCapacity, double pricePerKilometer, int carts) {
        super(passengerCapacity, pricePerKilometer, VehicleType.LAND);
        setId(id);
        setPassengerCapacity(passengerCapacity);
        setPricePerKilometer(pricePerKilometer);
        setCarts(carts);
    }


    @Override
    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }


    @Override
    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    private void setPassengerCapacity(int passengerCapacity) {
        if (passengerCapacity < PASSENGER_MIN_VALUE || passengerCapacity > PASSENGER_MAX_VALUE) {
            throw new IllegalArgumentException("A train cannot have less than 30 passengers or more than 150 passengers.");
        }
        this.passengerCapacity = passengerCapacity;
    }


    @Override
    public double getPricePerKilometer() {
        return pricePerKilometer;
    }

    private void setPricePerKilometer(double pricePerKilometer) {
        if (pricePerKilometer < PRICE_MIN_VALUE || pricePerKilometer > PRICE_MAX_VALUE) {
            throw new IllegalArgumentException("A vehicle with a price per kilometer lower than $0.10 or higher than $2.50 cannot exist!");
        }
        this.pricePerKilometer = pricePerKilometer;
    }

    @Override
    public int getCarts() {
        return carts;
    }

    private void setCarts(int carts) {
        if (carts < CARTS_MIN_VALUE || carts > CARTS_MAX_VALUE) {
            throw new IllegalArgumentException("A train cannot have less than 1 cart or more than 15 carts.");
        }
        this.carts = carts;
    }


    @Override
    public VehicleType getType() {
        return vehicleType;
    }


    @Override
    public String getAsString() {
        return String.format("Train ----%n%s" +
                        "Carts amount: %d%n",
                super.getAsString(), carts);
    }
}
