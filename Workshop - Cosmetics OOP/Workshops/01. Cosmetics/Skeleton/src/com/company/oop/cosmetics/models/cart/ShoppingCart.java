package com.company.oop.cosmetics.models.cart;
import com.company.oop.cosmetics.models.products.Product;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    
    private List<Product> productList;


    public ShoppingCart() {
        productList = new ArrayList<>();
    }

    public List<Product> getProductList() {
        return new ArrayList<>(productList);
    }


    private void setProductList(List<Product> productList) {
        this.productList = productList;
    }


    public void addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be empty");
        }
        productList.add(product);
    }


    public void removeProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be empty");
        }
        productList.remove(product);
    }


    public boolean containsProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be empty");
        } else return productList.contains(product);
    }


    public double totalPrice() {
        double totalPrice = 0.0;
        for (Product product : productList) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }
    
}
