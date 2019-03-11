package com.codecool.brain;

import java.io.Serializable;
import java.util.List;

public class Book implements Serializable{
    String author;
    String title;
    int numOfPages;
    List<String> content;

    List<String> getContent() {
        return content;
    }
    public Book() {
    }

    public Book(String author, String title, int numOfPages, List<String> content) {
        this.author = author;
        this.title = title;
        this.numOfPages = numOfPages;
        this.content = content;
    }


}


