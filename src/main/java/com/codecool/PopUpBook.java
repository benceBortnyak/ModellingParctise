package com.codecool;

public class PopUpBook extends Book{
    Enum<String> kind{city, farytale};
    public PopUpBook(String author, String title, int numOfPages, Boolean read,enum kind) {
        super(author, title, numOfPages, read);
        this.kind = kind;
    }
}
