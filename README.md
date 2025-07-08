# Fawry Challenge
This challenge simulates a simple bookstore system with shipping and checkout logic.

## Features
- Add a book to the inventory with some details like ISBN, title, year when the book is published, price
- Remove and return outdated books that passed specific number of years
- Buy a single book providing its ISBN, quantity, email, address

## Class Diagram Overview
These are the key classes and interfaces:-
- `BookInventory`: responsible for managing, buying books, and creating the shipping and mailing services
- `Book`: book model class
- `ShippingService`: responsible for shipping books
- `MailService`: responsible for mailing books
- `DeliveryType`: enum that contains different delivery types (SHIPPABLE, EMAILABLE, NONE)
- `Shippable`: interface that includes getTitle() and getAuthor()
- `Emailable`: interface that includes getTitle() and getFileType()
- `ShippableInfo`: wrapper used for shipping
- `EmailableInfo`: wrapper used for mailing

![Class Diagram](Diagrams/class_diagram.png)

## Example Output
```
You ordered this book successfully!
Processing details ....
Book Title: Book2
Book ISBN: isbn2
Book Author: Author2
Book Price: 150.0

Congratss book is for sale 

Sending Book2 to test@test.com
-----------
Thank you for paying 500.0
-----------
Removing outdated books ...
Book1
```

## Run Instructions
```bash
cd src
javac -d bin src/main/java/com/malak/*.java
java -cp bin com.malak.Main
```
