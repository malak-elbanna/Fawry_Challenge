package com.malak;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Product cheese = new Product("Cheese", 30, 5, LocalDate.of(2025, 12, 31), 350.5, true);
        Product tv = new Product("TV", 30000, 5, 8000, false);

        Customer customer = new Customer(1000);

        Cart cart = new Cart();
        cart.addProduct(cheese);
        cart.addProduct(cheese);
        cart.addProduct(tv);

        CheckoutService checkoutService = new CheckoutService();
        boolean success = false;

        Scanner scanner = new Scanner(System.in);

        while (!success) {
            try {
                checkoutService.checkout(customer, cart);
                success = true;
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
                System.out.println("Do you want to add more balance? (y/n)");
                String response = scanner.nextLine();

                if (response.equalsIgnoreCase("y")) {
                    System.out.println("Please enter how much you wanna add to your balance: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();
                    customer.addBalance(amount);
                } else {
                    break;
                }
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
                break;
            }
        }
    }
}