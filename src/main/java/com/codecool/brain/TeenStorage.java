package com.codecool.brain;

import java.io.Serializable;
import java.util.List;

public class TeenStorage extends Storage implements Serializable {

    private List<Book> storage;
    private int capacity;


    public TeenStorage(List<Book> storage, int capacity) {
        super("teen");
        this.storage = storage;
        this.capacity = capacity;
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

    @Override
    public String toString() {
        return "TeenStorage | " +
            "Capacity: " + capacity +
            "Storage: " + storage;
    }
}
