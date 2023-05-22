package com.company.cosmetics.models.products;

import com.company.cosmetics.models.common.GenderType;
import com.company.cosmetics.models.contracts.Product;


public class ProductBase implements Product {
    private static final int MIN_PRODUCT_NAME_LENGTH = 3;
    private static final int MAX_PRODUCT_NAME_LENGTH = 10;
    private static final int MIN_BRAND_NAME_LENGTH = 2;
    private static final int MAX_BRAND_NAME_LENGTH = 10;
    public static final String PRODUCT_NAME_ERROR_MESSAGE = "Product's name should be between 3 and 10 symbols long.";
    public static final String PRODUCT_BRAND_NAME_ERROR_MESSAGE = "Product's brand should be between 2 and 10 symbols long.";
    public static final String NEGATIVE_PRICE_ERROR_MESSAGE = "Price cannot be negative.";

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
            throw new IllegalArgumentException(PRODUCT_NAME_ERROR_MESSAGE);
        }
        this.name = name;
    }

    @Override
    public String getBrand() {
        return brand;
    }

    private void setBrand(String brand) {
        if (brand == null || brand.length() < MIN_BRAND_NAME_LENGTH || brand.length() > MAX_BRAND_NAME_LENGTH) {
            throw new IllegalArgumentException(PRODUCT_BRAND_NAME_ERROR_MESSAGE);
        }
        this.brand = brand;
    }

    @Override
    public double getPrice() {
        return price;
    }

    private void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException(NEGATIVE_PRICE_ERROR_MESSAGE);
        }
        this.price = price;
    }

    @Override
    public GenderType getGender() {
        return gender;
    }


    @Override
    public String print() {
        return String.format(
                "#%s " + "%s\n" + " #Price: $%.2f\n" + " #Gender: %s\n",
                name,
                brand,
                price,
                gender);
    }
}

