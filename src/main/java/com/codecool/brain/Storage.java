package com.codecool.brain;

import java.io.Serializable;
import java.util.List;

public class Storage implements Serializable {

    protected String type;
    private List<Book> storage;
    private int capacity;


    public Storage(String type, List<Book> storage, int capacity) {
        this.type = type;
        this.storage = storage;
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Storage" +
            "Type : " + type +
            "Storage : " + storage +
            "Capacity : " + capacity;
    }

    public List<Book> getStorage() {
        return storage;
    }

    public void setStorage(List<Book> storage) {
        this.storage = storage;
    }

    public int getCapacity() {
        return capacity;
    }
}
