package com.codecool;

public class PopUpBook extends Book{
    
    private Kind kind;

    public PopUpBook(String author, String title, int numOfPages,Kind kind) {
        super(author, title, numOfPages);
        this.kind = kind;
    }

    public Kind getKind() {
        return kind;
    }

    @Override
    public String toString() {
        return "PopUpBook |" +
            "Type :" +  kind + "|" +
            ", Author: " + author + "|" +
            ", Title: " + title + "|" +
            ", Number Of Pages: " + numOfPages + "|";
    }

}

