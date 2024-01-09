package org.example;

import java.util.ArrayList;
import java.util.List;

// Interface for managing items
interface IManageable {
    void add(Item item);
    void remove(Item item);
    void listAvailable();
    void listBorrowed();
}

// Abstract class for items
abstract class Item {
    String title;
    String uniqueID;
    boolean isBorrowed;

    public Item(String title, String uniqueID) {
        this.title = title;
        this.uniqueID = uniqueID;
        this.isBorrowed = false;
    }

    abstract void borrowItem();

    abstract void returnItem();

    // Getters and setters
    public String getTitle() {
        return title;
    }

    public String getUniqueID() {
        return uniqueID;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }
}

// Book class implementing Item
class Book extends Item {
    String author;

    public Book(String title, String uniqueID, String author) {
        super(title, uniqueID);
        this.author = author;
    }

    @Override
    void borrowItem() {
        if (!isBorrowed) {
            isBorrowed = true;
            System.out.println("Книга '" + title + "' позичена.");
        } else {
            System.out.println("Книга '" + title + "' вже позичена.");
        }
    }

    @Override
    void returnItem() {
        if (isBorrowed) {
            isBorrowed = false;
            System.out.println("Книга '" + title + "' повернена.");
        } else {
            System.out.println("Книга '" + title + "' вже повернена.");
        }
    }
}

// DVD class implementing Item
class DVD extends Item {
    int duration; // in minutes

    public DVD(String title, String uniqueID, int duration) {
        super(title, uniqueID);
        this.duration = duration;
    }

    @Override
    void borrowItem() {
        if (!isBorrowed) {
            isBorrowed = true;
            System.out.println("DVD '" + title + "' позичено.");
        } else {
            System.out.println("DVD '" + title + "' вже позичено.");
        }
    }

    @Override
    void returnItem() {
        if (isBorrowed) {
            isBorrowed = false;
            System.out.println("DVD '" + title + "' повернено.");
        } else {
            System.out.println("DVD '" + title + "' вже повернено.");
        }
    }
}

// Patron class representing a library patron
class Patron {
    String name;
    String ID;
    List<Item> borrowedItems;

    public Patron(String name, String ID) {
        this.name = name;
        this.ID = ID;
        this.borrowedItems = new ArrayList<>();
    }

    // Method to borrow an item
    public void borrow(Item item) {
        if (!item.isBorrowed()) {
            borrowedItems.add(item);
            item.borrowItem();
            System.out.println(name + " позичив(ла) " + item.getTitle());
        } else {
            System.out.println(item.getTitle() + " вже позичено.");
        }
    }

    // Method to return an item
    public void returnItem(Item item) {
        if (borrowedItems.contains(item)) {
            borrowedItems.remove(item);
            item.returnItem();
            System.out.println(name + " повернув(ла) " + item.getTitle());
        } else {
            System.out.println(item.getTitle() + " не було позичено цим читачем.");
        }
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public String getID() {
        return ID;
    }

    public List<Item> getBorrowedItems() {
        return borrowedItems;
    }
}

// Library class implementing IManageable
class Library implements IManageable {
    List<Item> items;
    List<Patron> patrons;

    public Library() {
        this.items = new ArrayList<>();
        this.patrons = new ArrayList<>();
    }

    @Override
    public void add(Item item) {
        items.add(item);
        System.out.println("Предмет '" + item.getTitle() + "' додано до бібліотеки.");
    }

    @Override
    public void remove(Item item) {
        if (items.remove(item)) {
            System.out.println("Предмет '" + item.getTitle() + "' видалено з бібліотеки.");
        } else {
            System.out.println("Предмет '" + item.getTitle() + "' не знайдено в бібліотеці.");
        }
    }

    @Override
    public void listAvailable() {
        System.out.println("Доступні предмети:");
        for (Item item : items) {
            if (!item.isBorrowed()) {
                System.out.println(item.getTitle());
            }
        }
    }

    @Override
    public void listBorrowed() {
        System.out.println("Позичені предмети та їхні читачі:");
        for (Item item : items) {
            if (item.isBorrowed()) {
                System.out.println(item.getTitle() + " - " + getPatronNameByItem(item));
            }
        }
    }

    // Method to register a new patron
    public void registerPatron(Patron patron) {
        patrons.add(patron);
        System.out.println("Читач " + patron.getName() + " зареєстрований.");
    }

    // Method to lend an item to a patron
    public void lendItem(Patron patron, Item item) {
        if (patrons.contains(patron) && items.contains(item) && !item.isBorrowed()) {
            patron.borrow(item);
        } else {
            System.out.println("Неможливо позичити предмет.");
        }
    }

    // Method to return a borrowed item
    public void returnItem(Patron patron, Item item) {
        if (patrons.contains(patron) && items.contains(item) && item.isBorrowed()) {
            patron.returnItem(item);
        } else {
            System.out.println("Неможливо повернути предмет.");
        }
    }

    // Helper method to get the name of the patron who borrowed the item
    private String getPatronNameByItem(Item item) {
        for (Patron patron : patrons) {
            if (patron.getBorrowedItems().contains(item)) {
                return patron.getName();
            }
        }
        return "Невідомо";
    }
}
