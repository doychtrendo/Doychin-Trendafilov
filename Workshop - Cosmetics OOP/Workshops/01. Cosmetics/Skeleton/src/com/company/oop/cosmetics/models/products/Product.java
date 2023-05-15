package com.company.oop.cosmetics.models.products;
import com.company.oop.cosmetics.models.common.GenderType;

public class Product {

    private static final int MIN_PRODUCT_NAME_LENGTH = 3;
    private static final int MAX_PRODUCT_NAME_LENGTH = 10;
    private static final int MIN_BRAND_NAME_LENGTH = 2;
    private static final int MAX_BRAND_NAME_LENGTH = 10;

    private double price;
    private String name;
    private String brand;
    private GenderType gender;

    public Product(String name, String brand, double price, GenderType gender) {
        setName(name);
        setBrand(brand);
        setPrice(price);
        setGender(gender);
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public GenderType getGender() {
        return gender;
    }

    private void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative.");
        }
        this.price = price;
    }

    private void setName(String name) {
        if (name.length() < MIN_PRODUCT_NAME_LENGTH || name.length() > MAX_PRODUCT_NAME_LENGTH) {
            throw new IllegalArgumentException("Product name must be between 3 and 10 characters");
        }
        this.name = name;
    }

    private void setBrand(String brand) {
        if (brand.length() < MIN_BRAND_NAME_LENGTH || brand.length() > MAX_BRAND_NAME_LENGTH) {
            throw new IllegalArgumentException("Brand name must be between 2 and 10 characters");
        }
        this.brand = brand;
    }

    private void setGender(GenderType gender) {
        this.gender = gender;
    }

    public String message (String name, String brand, double price, GenderType gender) {
        return String.format("#%s %s\n#Price: %.2f\n#Gender: %s\n===", name, brand, price, gender);
    }
    
}
