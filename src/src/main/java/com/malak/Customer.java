package com.malak;

public class Customer {
    private float balance;

    public Customer() {
        balance = 0.0f;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public void deductBalance(float amount) {
        balance -= amount;
    }
}
