package com.company.oop.dealership.models;

import com.company.oop.dealership.models.contracts.Priceable;
import com.company.oop.dealership.models.contracts.Vehicle;
import com.company.oop.dealership.utils.ValidationHelpers;

import static java.lang.String.format;

public abstract class BaseVehicle implements Vehicle, Priceable {

    private static final int MAKE_NAME_LEN_MIN = 2;
    private static final int MAKE_NAME_LEN_MAX = 15;
    private static final String MAKE_NAME_LEN_ERR = format(
            "Make must be between %s and %s characters long!",
            MAKE_NAME_LEN_MIN,
            MAKE_NAME_LEN_MAX);
    private static final int MODEL_NAME_LEN_MIN = 1;
    private static final int MODEL_NAME_LEN_MAX = 15;
    private static final String MODEL_NAME_LEN_ERR = format(
            "Model must be between %s and %s characters long!",
            MODEL_NAME_LEN_MIN,
            MODEL_NAME_LEN_MAX);
    private static final double PRICE_VAL_MIN = 0.0;
    private static final double PRICE_VAL_MAX = 1000000.0;
    private static final String PRICE_VAL_ERR = format(
            "Price must be between %.1f and %.1f!",
            PRICE_VAL_MIN,
            PRICE_VAL_MAX);

    private String make;
    private String model;
    private double price;

    public BaseVehicle(String make, String model, double price) {
        setMake(make);
        setModel(model);
        setPrice(price);
    }

    @Override
    public String getMake() {
        return make;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public double getPrice() {
        return price;
    }

    private void setMake(String make) {
        ValidationHelpers.validateStringRange(make, MAKE_NAME_LEN_MIN, MAKE_NAME_LEN_MAX, MAKE_NAME_LEN_ERR);
        this.make = make;
    }

    private void setModel(String model) {
        ValidationHelpers.validateStringRange(model, MODEL_NAME_LEN_MIN, MODEL_NAME_LEN_MAX, MODEL_NAME_LEN_ERR);
        this.model = model;
    }

    private void setPrice(double price) {
        ValidationHelpers.validateDecimalRange(price, PRICE_VAL_MIN, PRICE_VAL_MAX, PRICE_VAL_ERR);
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("Make: %s%n" +
                        "Model: %s%n" +
                        "Price: $%.0f%n%n",
                getMake(),
                getModel(),
                getPrice());
    }

}
