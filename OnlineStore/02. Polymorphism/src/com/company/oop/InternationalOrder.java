package com.company.oop;

import java.time.LocalDate;

public class InternationalOrder extends Order{

    public static final int MAX_PRODUCTS_LIMIT = 5;
    private String carrier;
    private int customsPercentage;

    public InternationalOrder(String recipient, Currency currency, LocalDate deliveryOn, String carrier, int customsPercentage) {
        super(recipient, currency, deliveryOn);
        setCarrier(carrier);
        setCustomsPercentage(customsPercentage);
    }

    public String getCarrier() {
        return carrier;
    }

    public int getCustomsPercentage() {
        return customsPercentage;
    }

    private void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    private void setCustomsPercentage(int customsPercentage) {
        this.customsPercentage = customsPercentage;
    }

    @Override
    public String getGeneralInfo() {
        return String.format("%s | Carrier: %s | *NOTE* - customs of %d%% expected but to be calculated on arrival.",
                super.getGeneralInfo(), getCarrier(), getCustomsPercentage());
    }

    @Override
    public void addItem(Product item) {
        if (getItems().size() >= MAX_PRODUCTS_LIMIT) {
            throw new IllegalArgumentException("International orders are limited to 5 products");
        }
        super.addItem(item);
    }
}
