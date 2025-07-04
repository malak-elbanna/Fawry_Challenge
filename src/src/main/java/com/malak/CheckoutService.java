package com.malak;

import java.util.List;
import java.util.Map;

public class CheckoutService {

    public CheckoutService() {}

    public void checkout(Customer customer, Cart cart) {
        if (cart.isEmpty()) {
            throw new IllegalStateException("Your cart is empty!");
        }

        cart.removeExpiredOrOutOfStockItems();
        List<Shippable> shippableList = cart.getShippableItems();
        ShippingService shippingService = new ShippingService();
        shippingService.shipItems(shippableList);
        System.out.println("** Checkout Receipt");
        for (Map.Entry<Product, Integer> entry : cart.getItems().entrySet()) {
            Product product = entry.getKey();
            Integer quantity = entry.getValue();

            System.out.println(quantity + "x " + product.getName() + "\t" + product.getPrice());
        }
        System.out.println("----------------------");

        double subtotal = cart.getSubtotal();
        double shipping = shippingService.calculateCost(shippableList);

        double totalAmount = subtotal + shipping;
        if (customer.getBalance() < totalAmount) {
            throw new ArithmeticException("Insufficient balance. You should pay "+ totalAmount);
        }

        customer.deductBalance(totalAmount);

        System.out.println("Subtotal\t" + subtotal);
        System.out.println("Shipping\t" + shipping);
        System.out.println("Amount\t" + (subtotal + shipping));
        cart.clear();
    }
}
