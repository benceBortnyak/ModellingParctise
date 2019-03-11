package com.codecool.brain;

import java.io.Serializable;
import java.util.List;

public class Cookbook extends Book implements Serializable{
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

