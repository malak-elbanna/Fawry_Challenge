package com.malak;

public class Customer {
    private double balance;

    public Customer(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void addBalance(double amount) {
        this.balance += amount;
    }

    public void deductBalance(double amount) {
        balance -= amount;
    }
}
