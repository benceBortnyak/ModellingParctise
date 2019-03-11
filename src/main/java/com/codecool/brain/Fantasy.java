package com.codecool.brain;

import java.io.Serializable;
import java.util.List;

public class Fantasy extends Book implements Serializable{
    String type;

    public Fantasy(String author, String title, int numOfPages, List<String> content, String type) {
        super(author, title, numOfPages, content);
        this.type = type;
    }

    @Override
    public String toString() {
        return "Fantasy{" +
            "type='" + type + '\'' +
            ", author='" + author + '\'' +
            ", title='" + title + '\'' +
            ", numOfPages=" + numOfPages +
            ", content=" + content +
            '}';
    }
}
