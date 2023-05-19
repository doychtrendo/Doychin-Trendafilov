package com.company.oop;

public class Product {

    public static final int MIN_NAME_LENGTH = 2;
    public static final int MAX_NAME_LENGTH = 15;

    private String name;
    private double price;
    private final Currency currency = Currency.USD; // default currency for all products

    public Product(String name, double price) {
        setName(name);
        setPrice(price);
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Currency getCurrency() {
        return currency;
    }

    private void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("Product name must be between 2 and 15 characters");
        }
        this.name = name;
    }

    private void setPrice(double price) {
        if (price <= 0.00) {
            throw new IllegalArgumentException("Product price must be positive");
        }
        this.price = price;
    }

    public String getDisplayInfo() {
        return String.format("%s - %.2f %s", getName(), getPrice(), getCurrency());
    }
}
