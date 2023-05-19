package com.company.oop;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {

    public static final double BGN_USD_CONVERSION_RATE = 1.75;
    public static final int MIN_RECIPIENT_LENGTH = 3;
    public static final int MAX_RECIPIENT_LENGTH = 35;

    private String recipient;
    private Currency currency;
    private LocalDate deliveryOn;
    private final List<Product> items;

    public Order(String recipient, Currency currency, LocalDate deliveryOn) {
        setRecipient(recipient);
        setCurrency(currency);
        setDeliveryOn(deliveryOn);
        items = new ArrayList<>();
    }

    public String getRecipient() {
        return recipient;
    }

    public Currency getCurrency() {
        return currency;
    }

    public LocalDate getDeliveryOn() {
        return deliveryOn;
    }

    public List<Product> getItems() {
        return new ArrayList<>(items);
    }

    private void setRecipient(String recipient) {
        if (recipient == null) {
            throw new IllegalArgumentException("Recipient cannot be empty");
        }
        if (recipient.length() < MIN_RECIPIENT_LENGTH || recipient.length() > MAX_RECIPIENT_LENGTH) {
            throw new IllegalArgumentException("Recipient name must be between 3 and 35 characters");
        }
        this.recipient = recipient;
    }

    private void setCurrency(Currency currency) {
        this.currency = currency;
    }

    private void setDeliveryOn(LocalDate deliveryOn) {
        this.deliveryOn = deliveryOn;
    }

    /*
     * No reason to expose our collection.
     * The addItem method is introduced instead so we can add items.
     */
    public void addItem(Product item) {

        // First check if the item is already in the collection.
        if (items.contains(item)) {
            throw new IllegalArgumentException("This item is already in this order");
        }

        items.add(item);
    }

    private double calculateTotalPrice() {
        double total = 0;
        for (Product item : items) {
            total += item.getPrice();
        }

        if (currency == Currency.BGN) {
            total = total * BGN_USD_CONVERSION_RATE;
        }
        return total;
    }

    public String getOrderItemsInfo() {
        if (items.size() == 0) {
            return "No items";
        }

        StringBuilder builder = new StringBuilder();
        for (Product item : items) {
            builder.append(String.format("  %s%n", item.getDisplayInfo()));
        }

        builder.append("-------------------------------------------------------------");

        return builder.toString();
    }

    public String getGeneralInfo() {
        return String.format(
                "Order to %s | Delivery on: %s | Total: %s",
                recipient,
                formatDeliveryDate(),
                formatPrice());
    }

    private String formatDeliveryDate() {
        return deliveryOn.format(DateTimeFormatter.ofPattern("dd MMM yyyy"));
    }

    private String formatPrice() {
        return String.format("%.2f %s", calculateTotalPrice(), currency);
    }
}
