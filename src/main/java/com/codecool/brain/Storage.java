package com.codecool.brain;

import java.io.Serializable;

public abstract class Storage implements Serializable {

    Storage() {
    }

    public abstract boolean typeCheck(Book book);

}
