package com.malak;

public class Book {
    private String isbn;
    private String title;
    private String author;
    private int year;
    private double price;
    private int quantity;
    private String fileType;
    private DeliveryType deliveryType;

    public Book(String isbn, String title, String author, int year, double price, int quantity, String fileType, int deliveryType) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.year = year;
        this.price = price;
        this.quantity = quantity;
        this.fileType = fileType;

        switch (deliveryType) {
            case 0:
                this.deliveryType = DeliveryType.SHIPPABLE;
                break;
            case 1:
                this.deliveryType = DeliveryType.EMAILABLE;
                break;
            case 2:
                this.deliveryType = DeliveryType.NONE;
                break;
        }
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getFileType() {
        return fileType;
    }

    public DeliveryType getDeliveryType() {
        return deliveryType;
    }

    public boolean isForSale() {
        return this.price > 0 && this.deliveryType != DeliveryType.NONE;
    }

    public boolean isOutdated(int currentYear, int threshold) {
        return (currentYear - this.year) > threshold;
    }

    public void decreaseQuantity(int amount) {
        if (amount > quantity) {
            throw new IllegalArgumentException("Not enough stock");
        }

        this.quantity -= amount;
    }
}
