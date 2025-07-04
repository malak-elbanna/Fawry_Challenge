package com.malak;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> items;

    public Cart() {
        items = new HashMap<Product, Integer>();
    }

    public void addProduct(Product p) {
        items.put(p, items.getOrDefault(p, 0) + 1);
        p.decreaseQuantity();
    }

    public void removeProduct(Product p) {
        items.remove(p);
    }

    public double getSubtotal() {
        double total = 0;
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            total += entry.getValue() * entry.getKey().getPrice();
        }
        return total;
    }

    public List<Shippable> getShippableItems() {
        List<Shippable> shippable = new ArrayList<>();
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();

            if (product.isShippable()) {
                double totalWeight = product.getWeight() * quantity;
                shippable.add(new ShippableItem(product.getName(), totalWeight, quantity));
            }
        }
        return shippable;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void removeExpiredOrOutOfStockItems() {
        List<Product> toRemove = new ArrayList<>();
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            Product product = entry.getKey();
            if (product.isExpired()) {
                System.out.println("\n" + product.getName() + " is expired");
                toRemove.add(product);
            } else if (product.isOutOfStock()) {
                System.out.println("\n" + product.getName() + " is out of stock");
                toRemove.add(product);
            }
        }

        for (Product product : toRemove) {
            removeProduct(product);
        }
    }

    public void clear() {
        items.clear();
    }

    public Map<Product, Integer> getItems() {
        return items;
    }
}
