package com.codecool.brain;

import java.io.Serializable;
import java.util.List;

public class Fantasy extends Book implements Serializable{
    private String type;

    public Fantasy(String author, String title, int numOfPages, List<String> content, String type) {
        super(author, title, numOfPages, content);
        this.type = type;
    }

    @Override
    public String toString() {
        List<String> cont = content;
        String contStr = String.join("",cont);
        return "Fantasy | " +
            "SubGenre: " + type + " | " +
            "Author: " + author + " | " +
            "Title: " + title + " | " +
            "Number of pages: " + numOfPages + " | " +
            "\n\tContent:"+ contStr;
    }
}
