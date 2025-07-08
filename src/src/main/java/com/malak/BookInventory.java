package com.malak;

import java.util.*;

public class BookInventory {
    private Map<String, Book> books;
    private ShippingService shippingService;
    private MailService mailService;

    public BookInventory() {
        books = new HashMap<>();
        shippingService = new ShippingService();
        mailService = new MailService();
    }

    public void addBook(Book book) {
        books.put(book.getIsbn(), book);
    }

    public List<Book> removeOutdatedBooks(int currentYear, int threshold) {
        List<Book> removedBooks = new ArrayList<>();

        Iterator<Map.Entry<String, Book>> iterator = books.entrySet().iterator();

        while (iterator.hasNext()) {
            Book book = iterator.next().getValue();
            if (book.isOutdated(currentYear, threshold)) {
                removedBooks.add(book);
                iterator.remove();
            }
        }
        return removedBooks;
    }

    public double buyBook(String isbn, int quantity, String email, String address) {
        Book book = books.get(isbn);
        if (book == null) {
            System.out.println("Book not found");
            return 0;
        }

        if (book.getQuantity() < quantity) {
            System.out.println("We don't have enough amount!");
            return 0;
        }

        book.decreaseQuantity(quantity);
        System.out.println("Successfull! You paid this book successfully");
        System.out.println("Processing details ....");

        if (book.getDeliveryType() == DeliveryType.EMAILABLE) {
            EmailableInfo item = new EmailableInfo(book);
            mailService.send(item, email);
        } else if (book.getDeliveryType() == DeliveryType.SHIPPABLE) {
            ShippableInfo item = new ShippableInfo(book);
            shippingService.ship(item, address);
        }

        return book.getPrice() * quantity;
    }
}
