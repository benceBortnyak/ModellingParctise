package com.codecool.brain;

import java.io.Serializable;
import java.util.List;

public class TeenStorage extends Storage implements Serializable {

    private List<Book> storage;
    private int capacity;
    private String type;

    public TeenStorage(List<Book> storage, int capacity) {
        this.storage = storage;
        this.capacity = capacity;
        this.type = "teen";
    }

    public boolean typeCheck(Book book){
        List<String> type = book.getContent();
        for (String contentType : type) {
            if (contentType.equals("teen")){
                return true;
            }
        }
        return false;
    }
}
