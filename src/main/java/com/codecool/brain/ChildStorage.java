package com.codecool.brain;

import java.io.Serializable;
import java.util.List;

public class ChildStorage extends Storage implements Serializable {

    private List<Book> storage;
    private int capacity;
    private String type;

    public ChildStorage(List<Book> storage, int capacity) {
        this.storage = storage;
        this.capacity = capacity;
        this.type ="Child";
    }

    public boolean typeCheck(Book book){
        List<String> type = book.getContent();
        for (String contentType : type) {
            if (contentType.equals("child")){
                return true;
            }
        }
        return false;
    }


}
