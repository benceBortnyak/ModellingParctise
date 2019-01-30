package com.codecool;

public class Book {
    String author;
    String title;
    int numOfPages;
    Boolean read = false;
    public Book(String author, String title, int numOfPages, Boolean read) {
        this.author = author;
        this.title = title;
        this.numOfPages = numOfPages;
        this.read = read;
    }
}
