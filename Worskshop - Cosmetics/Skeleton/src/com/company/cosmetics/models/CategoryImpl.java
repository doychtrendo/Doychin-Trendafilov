package com.company.cosmetics.models;


import com.company.cosmetics.models.contracts.Category;
import com.company.cosmetics.models.contracts.Product;

import java.util.ArrayList;
import java.util.List;

public class CategoryImpl implements Category {
    public static final int MIN_CATEGORY_NAME_LENGTH = 2;
    public static final int MAX_CATEGORY_NAME_LENGTH = 15;
    public static final String NAME_ERROR_MESSAGE = "Product's name should be between 3 and 10 symbols long.";
    public static final String REMOVE_PRODUCT_ERROR_MESSAGE = "Product does not exist.";

    private String name;
    private final List<Product> products;

    public CategoryImpl(String name) {
        setName(name);
        products = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.length() < MIN_CATEGORY_NAME_LENGTH || name.length() > MAX_CATEGORY_NAME_LENGTH) {
            throw new IllegalArgumentException(NAME_ERROR_MESSAGE);
        }
        this.name = name;
    }

    public List<Product> getProducts() {
        //todo why are we returning a copy? Replace this comment with explanation! - We return a copy, so that the list cannot be manipulated through the getter.
        return new ArrayList<>(products);
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        if (!products.contains(product)) {
            throw new IllegalArgumentException(REMOVE_PRODUCT_ERROR_MESSAGE);
        }
        products.remove(product);
    }

    public String print() {
        StringBuilder sb = new StringBuilder();
        if (products.size() == 0) {
            return String.format("#Category: %s\n" +
                    " #No product in this category", name);
        } else {
            for (Product product : products) {
                sb.append(product.print());
            }
        }
        return sb.toString();
    }
}
