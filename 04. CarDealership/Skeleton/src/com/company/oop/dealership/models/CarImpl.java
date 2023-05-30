package com.company.oop.dealership.models;

import com.company.oop.dealership.models.contracts.Car;
import com.company.oop.dealership.models.contracts.Comment;
import com.company.oop.dealership.models.enums.VehicleType;
import com.company.oop.dealership.utils.ValidationHelpers;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

public class CarImpl extends BaseVehicle implements Car {

    private static final int CAR_SEATS_MIN = 1;
    private static final int CAR_SEATS_MAX = 10;
    private static final String CAR_SEATS_ERR = format(
            "Seats must be between %d and %d!",
            CAR_SEATS_MIN,
            CAR_SEATS_MAX);

    private int seats;
    private final List<Comment> comments;

    public CarImpl(String make, String model, double price, int seats) {
        super(make, model, price);
        setSeats(seats);
        this.comments = new ArrayList<>();
    }

    @Override
    public int getWheels() {
        return 4;
    }

    @Override
    public int getSeats() {
        return seats;
    }

    @Override
    public VehicleType getType() {
        return VehicleType.CAR;
    }

    private void setSeats(int seats) {
        ValidationHelpers.validateIntRange(seats, CAR_SEATS_MIN, CAR_SEATS_MAX, CAR_SEATS_ERR);
        this.seats = seats;
    }

    @Override
    public List<Comment> getComments() {
        return new ArrayList<>(comments);
    }

    @Override
    public void addComment(Comment comment) {
        comments.add(comment);
    }

    @Override
    public void removeComment(Comment comment) {
        comments.remove(comment);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Car:\n")
                .append(String.format("Make: %s%n", getMake()))
                .append(String.format("Model: %s%n", getModel()))
                .append(String.format("Wheels: %d%n", getWheels()))
                .append(String.format("Price: $%.0f%n", getPrice()))
                .append(String.format("Seats: %d%n", getSeats()));
        List<Comment> comments = getComments();
        if (comments.isEmpty()) {
            sb.append("--NO COMMENTS--");
        } else {
            sb.append("--COMMENTS--\n");
            for (Comment comment : comments) {
                sb.append(comment)
                        .append("\n");
            }
            sb.append("--COMMENTS--");
        }
        return sb.toString();
    }

}
