package org.example;

import java.util.ArrayList;
import java.util.Iterator;

class Book {
    private String title;
    private String author;
    private String isbn;
    private int year;

    public Book(String title, String author, String isbn, int year) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", ISBN: " + isbn + ", Year: " + year;
    }
}

class Library {
    private ArrayList<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added to the library.");
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("The library is empty.");
        } else {
            System.out.println("Books in the library:");
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    public void searchBookByTitle(String title) {
        Iterator<Book> iterator = books.iterator();
        boolean found = false;

        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Book found:\n" + book);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Book not found in the library.");
        }
    }

    public void removeBookByIsbn(String isbn) {
        Iterator<Book> iterator = books.iterator();
        boolean removed = false;

        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getIsbn().equals(isbn)) {
                iterator.remove();
                System.out.println("Book removed from the library.");
                removed = true;
                break;
            }
        }

        if (!removed) {
            System.out.println("Book with ISBN " + isbn + " not found in the library.");
        }
    }
}


