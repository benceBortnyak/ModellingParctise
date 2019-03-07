package com.codecool.Brain;

import com.codecool.Brain.Book;

import java.util.List;

public class Fantasy extends Book {
    String type;

    public Fantasy(String author, String title, int numOfPages, List<String> content, String type) {
        super(author, title, numOfPages, content);
        this.type = type;
    }
}
