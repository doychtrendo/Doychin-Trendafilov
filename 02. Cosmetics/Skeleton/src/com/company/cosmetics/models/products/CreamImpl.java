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
        return String.format("#Category: Creams\n"
                        + "%s"
                        + " #Scent: %s\n"
                        + " ===",
                super.print(), scentType);
    }
}
