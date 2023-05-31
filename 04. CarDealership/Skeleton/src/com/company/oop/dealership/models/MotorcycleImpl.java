package com.company.oop.dealership.models;

import com.company.oop.dealership.models.contracts.Comment;
import com.company.oop.dealership.models.contracts.Motorcycle;
import com.company.oop.dealership.models.enums.VehicleType;
import com.company.oop.dealership.utils.ValidationHelpers;

import java.util.List;

import static java.lang.String.format;

public class MotorcycleImpl extends BaseVehicle implements Motorcycle {

    private static final int CATEGORY_LEN_MIN = 3;
    private static final int CATEGORY_LEN_MAX = 10;
    private static final String CATEGORY_LEN_ERR = format(
            "Category must be between %d and %d characters long!",
            CATEGORY_LEN_MIN,
            CATEGORY_LEN_MAX);

    private String category;

    public MotorcycleImpl(String make, String model, double price, String category) {
        super(make, model, price);
        setCategory(category);
    }

    @Override
    public int getWheels() {
        return 2;
    }

    @Override
    public String getCategory() {
        return category;
    }

    @Override
    public VehicleType getType() {
        return VehicleType.MOTORCYCLE;
    }

    private void setCategory(String category) {
        ValidationHelpers.validateStringRange(category, CATEGORY_LEN_MIN, CATEGORY_LEN_MAX, CATEGORY_LEN_ERR);
        this.category = category;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Motorcycle:\n")
                .append(super.toString())
                .append("Category: ").append(getCategory()).append("\n");
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
