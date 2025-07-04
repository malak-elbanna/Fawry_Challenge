package com.malak;

import java.util.List;

public class ShippingService {
    private static final double costPerGram = 0.25;

    public ShippingService() {}

    public void shipItems(List<Shippable> items) {
        System.out.println("** Shipment Notice **");
        double totalWeight = 0;
        for (Shippable item : items) {
            totalWeight += item.getWeight();
            System.out.println(item.getName() + "\t" + item.getWeight() + "g\n");
        }
        System.out.println("Total package weight is " + totalWeight + "g\n");
    }

    public double calculateCost(List<Shippable> items) {
        double totalWeight = 0;
        for (Shippable item : items) {
            totalWeight += item.getWeight();
        }
        return totalWeight * costPerGram;
    }
}
