package com.codecool.Brain;

import java.util.List;

public class AdultStorage extends Storage {

    private List<Book> storage;
    private int capacity;
    private String type;

    public AdultStorage(List<Book> storage, int capacity) {
        this.storage = storage;
        this.capacity = capacity;
        this.type = "Adult";
    }

    public boolean typeCheck(Book book){
        List<String> type = book.getContent();
        for (String contentType : type) {
            if (contentType.equals("Adult")){
                return true;
            }
        }
        return false;
    }


}
