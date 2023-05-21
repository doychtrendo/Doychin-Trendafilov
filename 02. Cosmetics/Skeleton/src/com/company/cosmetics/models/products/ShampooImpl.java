package com.company.cosmetics.models.products;

import com.company.cosmetics.models.common.GenderType;
import com.company.cosmetics.models.common.UsageType;
import com.company.cosmetics.models.contracts.Shampoo;


public class ShampooImpl extends ProductBase implements Shampoo {

    private int milliliters;
    private UsageType usageType;

    public ShampooImpl(String name, String brand, double price, GenderType gender, int milliliters, UsageType usageType) {
        super(name, brand, price, gender);
        setMilliliters(milliliters);
        setUsageType(usageType);
    }

    @Override
    public int getMilliliters() {
        return milliliters;
    }

    private void setMilliliters(int milliliters) {
        if (milliliters < 0) {
            throw new IllegalArgumentException("Milliliters cannot be a negative number.");
        }
        this.milliliters = milliliters;
    }

    @Override
    public UsageType getUsage() {
        return usageType;
    }

    private void setUsageType(UsageType usageType) {
        this.usageType = usageType;
    }

    @Override
    public String print() {
        StringBuilder sb = new StringBuilder();
        sb.append("#Category: Shampoos\n");
        sb.append(String.format("#%s %s%n", getName(), getBrand()));
        sb.append(String.format(" #Price: $%.2f%n", getPrice()));
        sb.append(String.format(" #Gender: %s%n", getGender()));
        sb.append(String.format(" #Milliliters: %d%n", getMilliliters()));
        sb.append(String.format(" #Usage: %s%n", getUsage()));
        sb.append(" ===");

        return sb.toString();
    }

}
