package com.company.cosmetics.models.products;

import com.company.cosmetics.models.common.GenderType;
import com.company.cosmetics.models.contracts.Toothpaste;

import java.util.ArrayList;
import java.util.List;

public class ToothpasteImpl extends ProductBase implements Toothpaste {

    private List<String> ingredients;

    public ToothpasteImpl(String name, String brand, double price, GenderType gender, List<String> ingredients) {
        super(name, brand, price, gender);
        setIngredients(ingredients);
    }

    @Override
    public List<String> getIngredients() {
        return new ArrayList<>(this.ingredients);
    }

    private void setIngredients(List<String> ingredients) {
        if (ingredients == null) {
            throw new IllegalArgumentException("Ingredients cannot be null.");
        }
        this.ingredients = new ArrayList<>(ingredients);
    }

    @Override
    public String print() {
        StringBuilder sb = new StringBuilder();
        sb.append("#Category: Toothpastes\n");
        sb.append(String.format("#%s %s%n", getName(), getBrand()));
        sb.append(String.format(" #Price: $%.2f%n", getPrice()));
        sb.append(String.format(" #Gender: %s%n", getGender()));
        sb.append(String.format(" #Ingredients: %s%n", getIngredients()));
        sb.append(" ===");

        return sb.toString();
    }

}
