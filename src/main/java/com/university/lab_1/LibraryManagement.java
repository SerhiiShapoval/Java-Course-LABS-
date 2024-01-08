package com.university.lab_1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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

    public String getIsbn() {
        return isbn;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", ISBN: " + isbn;
    }
}

class Library {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void showAllBooks() {
        books.forEach(System.out::println);
    }

    public Book findBookByTitle(String title) {
        return books.stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .orElse(null);
    }

    public void removeBookByIsbn(String isbn) {
        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getIsbn().equals(isbn)) {
                iterator.remove();
            }
        }
    }
}

public class LibraryManagement {
    public static void main(String[] args) {
        Library library = new Library();

        library.addBook(new Book("Book 1", "Author 1", "ISBN1", 2020));
        library.addBook(new Book("Book 2", "Author 2", "ISBN2", 2019));
        library.addBook(new Book("Book 3", "Author 3", "ISBN3", 2021));

        System.out.println("All Books in Library:");
        library.showAllBooks();

        String searchTitle = "Book 2";
        Book foundBook = library.findBookByTitle(searchTitle);
        if (foundBook != null) {
            System.out.println("\nFound Book by Title: " + foundBook);
        } else {
            System.out.println("\nBook not found with title: " + searchTitle);
        }

        String isbnToDelete = "ISBN2";
        library.removeBookByIsbn(isbnToDelete);

        System.out.println("\nBooks in Library after removing book with ISBN: " + isbnToDelete);
        library.showAllBooks();
    }
}