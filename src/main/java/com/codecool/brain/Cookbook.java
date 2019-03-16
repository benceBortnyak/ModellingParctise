package com.codecool.brain;

import java.io.Serializable;

import java.util.List;


public class Cookbook extends Book implements Serializable {
    private String foodKind;

    public Cookbook(String author, String title, int numOfPages, List<String> content, String foodKind) {
        super(author, title, numOfPages, content);
        this.foodKind = foodKind;
    }

    @Override
    public String toString() {
        List<String> cont = content;
        String contStr = String.join("", cont);
        return "Cookbook | " +
            "Food type: " + foodKind + " | " +
            "Author: " + author + " | " +
            "Title: " + title + " | " +
            "Number of pages: " + numOfPages + " | " +
            "\n\tContent:" + contStr;
    }

}

