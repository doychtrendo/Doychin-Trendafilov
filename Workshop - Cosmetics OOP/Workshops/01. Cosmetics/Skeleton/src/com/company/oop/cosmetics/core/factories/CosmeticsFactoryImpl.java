package com.company.oop.cosmetics.core.factories;
import com.company.oop.cosmetics.core.contracts.CosmeticsRepository;
import com.company.oop.cosmetics.models.Category;
import com.company.oop.cosmetics.models.cart.ShoppingCart;
import com.company.oop.cosmetics.models.common.GenderType;
import com.company.oop.cosmetics.models.products.Product;
import com.company.oop.cosmetics.core.contracts.CosmeticsFactory;

import java.util.List;

import static com.company.oop.cosmetics.commands.CommandConstants.*;

public class CosmeticsFactoryImpl implements CosmeticsFactory {

    
    public Category createCategory(String name) {
        return new Category(name);
    }

    @Override
    public Product createProduct(String name, String brand, double price, String gender) {
        return new Product(name, brand, price, GenderType.valueOf(gender));
    }

    public ShoppingCart createShoppingCart() {
        return new ShoppingCart();
    }
    
}
