package com.codecool.Brain;

import java.util.List;

public class Book {
    String author;
    String title;
    int numOfPages;
    List<String> content;

    public Book(String author, String title, int numOfPages, List<String> content) {
        this.author = author;
        this.title = title;
        this.numOfPages = numOfPages;
        this.content = content;
    }

}


