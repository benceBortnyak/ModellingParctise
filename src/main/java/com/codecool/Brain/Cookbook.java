package com.codecool.Brain;

import com.codecool.Brain.Book;

import java.util.List;

public class Cookbook extends Book {
    String foodKind;

    public Cookbook(String author, String title, int numOfPages, List<String> content, String foodKind) {
        super(author, title, numOfPages, content);
        this.foodKind = foodKind;
    }

    @Override
    public String toString() {
        return "Cookbook{" +
            "foodKind='" + foodKind + '\'' +
            ", author='" + author + '\'' +
            ", title='" + title + '\'' +
            ", numOfPages=" + numOfPages +
            ", content=" + content +
            '}';
    }
}

