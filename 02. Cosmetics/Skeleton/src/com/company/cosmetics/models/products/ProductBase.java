package com.company.cosmetics.models.products;

import com.company.cosmetics.models.common.GenderType;
import com.company.cosmetics.models.contracts.Product;


public class ProductBase implements Product {
    private static final int MIN_PRODUCT_NAME_LENGTH = 3;
    private static final int MAX_PRODUCT_NAME_LENGTH = 10;
    private static final int MIN_BRAND_NAME_LENGTH = 2;
    private static final int MAX_BRAND_NAME_LENGTH = 10;

    private String name;
    private String brand;
    private double price;
    private final GenderType gender;

    protected ProductBase(String name, String brand, double price, GenderType gender) {
        setName(name);
        setBrand(brand);
        setPrice(price);
        this.gender = gender;
    }

    @Override
    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name == null || name.length() < MIN_PRODUCT_NAME_LENGTH || name.length() > MAX_PRODUCT_NAME_LENGTH) {
            throw new IllegalArgumentException("Product's name should be between 3 and 10 symbols long.");
        }
        this.name = name;
    }

    @Override
    public String getBrand() {
        return brand;
    }

    private void setBrand(String brand) {
        if (brand == null || brand.length() < MIN_BRAND_NAME_LENGTH || brand.length() > MAX_BRAND_NAME_LENGTH) {
            throw new IllegalArgumentException("Product's brand should be between 2 and 10 symbols long.");
        }
        this.brand = brand;
    }

    @Override
    public double getPrice() {
        return price;
    }

    private void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative.");
        }
        this.price = price;
    }

    @Override
    public GenderType getGender() {
        return gender;
    }

    @Override
    public String print() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("#Category: %s%n", getClass().getSimpleName()));
        sb.append(String.format("#%s %s%n", getName(), getBrand()));
        sb.append(String.format(" #Price: $%.2f%n", getPrice()));
        sb.append(String.format(" #Gender: %s%n", getGender()));

        return sb.toString();
    }
}

