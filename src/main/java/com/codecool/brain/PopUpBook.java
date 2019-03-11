package com.codecool.brain;

import java.io.Serializable;
import java.util.List;

public class PopUpBook extends Book implements Serializable{
    
    private Kind kind;

    public PopUpBook(String author, String title, int numOfPages, List<String> content, Kind kind) {
        super(author, title, numOfPages, content);
        this.kind = kind;
    }


    @Override
    public String toString() {
        return "PopUpBook{" +
            "kind=" + kind +
            ", author='" + author + '\'' +
            ", title='" + title + '\'' +
            ", numOfPages=" + numOfPages +
            ", content=" + content +
            '}';
    }
}

