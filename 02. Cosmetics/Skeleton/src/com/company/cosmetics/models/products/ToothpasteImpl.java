package com.company.cosmetics.models.products;

import com.company.cosmetics.models.common.GenderType;
import com.company.cosmetics.models.contracts.Toothpaste;

import java.util.ArrayList;
import java.util.List;

public class ToothpasteImpl extends ProductBase implements Toothpaste {

    public static final String INGREDIENTS_ERROR_MESSAGE = "Ingredients cannot be null.";

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
            throw new IllegalArgumentException(INGREDIENTS_ERROR_MESSAGE);
        }
        this.ingredients = new ArrayList<>(ingredients);
    }

    @Override
    public String print() {
        return String.format("#Category: Toothpastes\n"
                        + "%s"
                        + " #Ingredients: %s\n"
                        + " ===",
                super.print(), getIngredients());
    }

}
