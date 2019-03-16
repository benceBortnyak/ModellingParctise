package com.codecool.brain;

import java.io.Serializable;
import java.util.List;

public abstract class Storage implements Serializable {

    protected String type;

    public Storage(){}

    Storage(String type) {
        this.type = type;
    }

    public boolean typeCheck(Book book) {
        List<String> type = book.getContent();
        for (String contentType : type) {
            if (contentType.equals(type)){
                return true;
            }
        }
        return false;
    }

}
