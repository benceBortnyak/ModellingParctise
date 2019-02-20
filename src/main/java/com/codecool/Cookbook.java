package com.codecool;

public class Cookbook extends Book{
    private String foodKind;
    public Cookbook(String author, String title, int numOfPages,String foodKind) {
        super(author, title, numOfPages);
        this.foodKind = foodKind;
    }

    @Override
    public String toString() {
        return "Cookbook |" +
            "Main food type: " + foodKind + "|" +
            ", Author: " + author + "|" +
            ", Title " + title + "|" +
            ", Number of pages" + numOfPages + "|";
    }
}

