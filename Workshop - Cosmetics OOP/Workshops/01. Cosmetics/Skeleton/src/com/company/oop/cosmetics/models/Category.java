package com.company.oop.cosmetics.models;
import com.company.oop.cosmetics.models.products.Product;
import java.util.ArrayList;
import java.util.List;

public class Category {

    private static final int MIN_CATEGORY_NAME_LENGTH = 2;
    private static final int MAX_CATEGORY_NAME_LENGTH = 15;
    private String name;
    private final List<Product> products;

    public Category(String name) {
        setName(name);
        products = new ArrayList<>();

    }

    public String getName () {
        return name;
    }

    private void setName (String name) {
        if (name.length() < MIN_CATEGORY_NAME_LENGTH || name.length() > MAX_CATEGORY_NAME_LENGTH) {
            throw new IllegalArgumentException("Product name must be between 2 and 15 characters");
        }
        this.name = name;
    }

    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }

    public void addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        products.add(product);
    }

    public void removeProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        if (!products.contains(product)) {
            throw new IllegalArgumentException("Product not found");
        }
        products.remove(product);
    }

    public String print() {
        StringBuilder sb = new StringBuilder();

        sb.append("#Category: ").append(getName()).append("\n");

        if (products.isEmpty()) {
            sb.append(" #No product in this category");
        } else {
            for (Product product : products) {
                sb.append(" #").append(product.getName()).append(" ").append(product.getBrand()).append("\n");
                sb.append(" #Price: $").append(product.getPrice()).append("\n");
                sb.append(" #Gender: ").append(product.getGender()).append("\n");
                sb.append("===\n");
            }
        }
        return sb.toString();
    }
}
