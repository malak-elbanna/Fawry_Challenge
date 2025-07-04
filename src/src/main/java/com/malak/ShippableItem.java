package com.malak;

public class ShippableItem implements Shippable {
    private String name;
    private double weight;

    public ShippableItem(String name, double weight, int quantity) {
        this.name = quantity + "x " + name;
        this.weight = weight;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}
