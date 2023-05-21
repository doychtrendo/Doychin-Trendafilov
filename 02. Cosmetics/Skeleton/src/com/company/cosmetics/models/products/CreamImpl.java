package com.company.cosmetics.models.products;

import com.company.cosmetics.models.common.GenderType;
import com.company.cosmetics.models.common.ScentType;
import com.company.cosmetics.models.contracts.Cream;


public class CreamImpl extends ProductBase implements Cream {

    private ScentType scentType;

    public CreamImpl(String name, String brand, double price, GenderType gender, ScentType scent) {
        super(name, brand, price, gender);
        setScentType(scent);
    }

    @Override
    public ScentType getScent() {
        return scentType;
    }

    private void setScentType(ScentType scentType) {
        this.scentType = scentType;
    }

    @Override
    public String print() {
        StringBuilder sb = new StringBuilder();
        sb.append("#Category: Creams\n");
        sb.append(String.format("#%s %s%n", getName(), getBrand()));
        sb.append(String.format(" #Price: $%.2f%n", getPrice()));
        sb.append(String.format(" #Gender: %s%n", getGender()));
        sb.append(String.format(" #Scent: %s%n", getScent()));
        sb.append(" ===");

        return sb.toString();
    }
}
