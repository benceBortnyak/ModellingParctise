package com.codecool.brain;

import java.io.Serializable;
import java.util.List;

public class AdultStorage extends Storage implements Serializable {

    private List<Book> storage;
    private int capacity;


    public AdultStorage(List<Book> storage, int capacity) {
        super("adult");
        this.storage = storage;
        this.capacity = capacity;

    }

    public boolean typeCheck(Book book){
        List<String> type = book.getContent();
        for (String contentType : type) {
            if (contentType.equals("adult")){
                return true;
            }
        }
        return false;
    }


}
