package com.company.oop;

import java.time.LocalDate;

public class InternationalOrder extends Order {

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

    public String getInternationalOrderGeneralInfo() {
        return String.format(
                "%s | Carrier: %s | *NOTE* - customs of %d%% expected but to be calculated on arrival.",
                super.getGeneralInfo(),
                getCarrier(),
                getCustomsPercentage());
    }
}
