package com.codecool.brain;

import java.io.Serializable;
import java.util.List;

public class ChildStorage extends Storage implements Serializable {

    private List<Book> storage;
    private int capacity;

    public ChildStorage(List<Book> storage, int capacity) {
        super("child");
        this.storage = storage;
        this.capacity = capacity;

    }

}
