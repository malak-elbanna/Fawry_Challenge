package com.malak;

public class ShippableInfo implements Shippable {
    private String title;
    private String author;

    public ShippableInfo(Book book) {
        title = book.getTitle();
        author = book.getAuthor();
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}
