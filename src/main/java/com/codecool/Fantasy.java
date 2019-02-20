package com.codecool;

public class Fantasy extends Book {
    private String type;
    public Fantasy(String author, String title, int numOfPages, String type) {
        super(author, title, numOfPages);
        this.type=type;

    }

    @Override
    public String toString() {
        return "Fantasy |" +
            "Type: " + type + "|" +
            ", Author: "  + author + "|" +
            ", Title: " + title + '|' +
            ", Number Of Pages: " + numOfPages + "|";


    }

}
