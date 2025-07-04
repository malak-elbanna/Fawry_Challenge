package com.malak;

import java.time.LocalDate;
import java.util.Optional;

public class Product {
    private String name;
    private float price;
    private int quantity;
    private Optional<LocalDate> expiryDate;
    private double weight;
    private boolean isShippable;

    public Product(String name, float price, int quantity, LocalDate expiryDate, double weight, boolean isShippable) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.expiryDate = Optional.of(expiryDate);
        this.weight = weight;
        this.isShippable = isShippable;
    }

    public Product(String name, float price, int quantity, double weight, boolean isShippable) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.expiryDate = Optional.empty();
        this.weight = weight;
        this.isShippable = isShippable;
    }

    public boolean isExpired() {
        return expiryDate.isPresent() && expiryDate.get().isBefore(LocalDate.now());
    }

    public boolean isOutOfStock() {
        return quantity <= 0;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void decreaseQuantity() {
        quantity--;
    }

    public Optional<LocalDate> getExpiryDate() {
        return expiryDate;
    }

    public double getWeight() {
        return weight;
    }

    public boolean isShippable() {
        return isShippable;
    }
}
