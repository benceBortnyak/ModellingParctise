package com.codecool.Brain;

import java.util.List;

public class TeenStorage extends Storage{

    private List<Book> storage;
    private int capacity;
    private String type;

    public TeenStorage(List<Book> storage, int capacity) {
        this.storage = storage;
        this.capacity = capacity;
        this.type = "Teen";
    }

    public boolean typeCheck(Book book){
        List<String> type = book.getContent();
        for (String contentType : type) {
            if (contentType.equals("Teen")){
                return true;
            }
        }
        return false;
    }
}
