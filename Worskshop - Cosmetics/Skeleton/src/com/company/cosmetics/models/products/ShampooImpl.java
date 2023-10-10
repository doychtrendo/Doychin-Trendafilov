package com.company.cosmetics.models.products;

import com.company.cosmetics.models.common.GenderType;
import com.company.cosmetics.models.common.UsageType;
import com.company.cosmetics.models.contracts.Shampoo;


public class ShampooImpl extends ProductBase implements Shampoo {

    public static final String MILLILITERS_ERROR_MESSAGE = "Milliliters cannot be a negative number.";

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
            throw new IllegalArgumentException(MILLILITERS_ERROR_MESSAGE);
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
        return String.format("#Category: Shampoos\n" +
                        "%s" + " "
                        + "#Milliliters: %d\n" + " "
                        + "#Usage: %s\n"
                        + " ===",
                super.print(), getMilliliters(), getUsage());
    }

}
