package com.codecool.brain;

import java.io.Serializable;
import java.util.List;

public class PopUpBook extends Book implements Serializable {

    private Kind kind;

    public PopUpBook(String author, String title, int numOfPages, List<String> content, Kind kind) {
        super(author, title, numOfPages, content);
        this.kind = kind;
    }


    @Override
    public String toString() {
        List<String> cont = content;
        String contStr = String.join("", cont);
        return "PopUpBook | " +
            "Type: " + kind + " | " +
            "Author: " + author + " | " +
            "Title: " + title + " | " +
            "Number of pages: " + numOfPages + " | " +
            "\n\tContent:" + contStr;
    }
}

