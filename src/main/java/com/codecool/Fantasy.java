package com.codecool;

public class Fantasy extends Book {
    String type;
    public Fantasy(String author, String title, int numOfPages, Boolean read) {
        super(author, title, numOfPages, read);
        this.type=type;

    }
}
