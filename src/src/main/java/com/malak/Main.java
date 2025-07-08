package com.malak;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        BookInventory bookInventory = new BookInventory();

        Book book1 = new Book("isbn1", "Book1", "Author1", 2005, 500, 10, "pdf", 2);
        Book book2 = new Book("isbn2", "Book2", "Author2", 2024, 150, 10, "pdf", 1);
        Book book3 = new Book("isbn3", "Book3", "Author3", 2012, 650, 10, "pdf", 0);

        bookInventory.addBook(book1);
        bookInventory.addBook(book2);
        bookInventory.addBook(book3);

        double totalPrice = bookInventory.buyBook("isbn2", 5, "test@test.com", "test");
        System.out.println("-----------");
        System.out.println("Thank you for paying "+ totalPrice);

        System.out.println("-----------");
        System.out.println("Removing outdated books ...");
        List<Book> removed = bookInventory.removeOutdatedBooks(2025, 13);

        for (Book book : removed) {
            System.out.println(book.getTitle());
        }
    }
}