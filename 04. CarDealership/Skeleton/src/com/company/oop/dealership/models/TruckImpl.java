package com.company.oop.dealership.models;

import com.company.oop.dealership.models.contracts.Comment;
import com.company.oop.dealership.models.contracts.Truck;
import com.company.oop.dealership.models.enums.VehicleType;
import com.company.oop.dealership.utils.ValidationHelpers;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

public class TruckImpl extends BaseVehicle implements Truck {

    private static final int WEIGHT_CAP_MIN = 1;
    private static final int WEIGHT_CAP_MAX = 100;
    private static final String WEIGHT_CAP_ERR = format(
            "Weight capacity must be between %d and %d!",
            WEIGHT_CAP_MIN,
            WEIGHT_CAP_MAX);

    private int weightCapacity;
    private final List<Comment> comments;

    public TruckImpl(String make, String model, double price, int weightCapacity) {
        super(make, model, price);
        getWheels();
        setWeightCapacity(weightCapacity);
        this.comments = new ArrayList<>();
    }

    @Override
    public int getWheels() {
        return 8;
    }

    @Override
    public int getWeightCapacity() {
        return weightCapacity;
    }

    @Override
    public VehicleType getType() {
        return VehicleType.TRUCK;
    }

    private void setWeightCapacity(int weightCapacity) {
        ValidationHelpers.validateIntRange(weightCapacity, WEIGHT_CAP_MIN, WEIGHT_CAP_MAX, WEIGHT_CAP_ERR);
        this.weightCapacity = weightCapacity;
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
        sb.append("Truck:\n")
                .append("Make: ").append(getMake()).append("\n")
                .append("Model: ").append(getModel()).append("\n")
                .append("Wheels: ").append(getWheels()).append("\n")
                .append("Price: $").append(String.format("%.0f", getPrice())).append("\n")
                .append("Weight Capacity: ").append(getWeightCapacity()).append("t").append("\n");
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