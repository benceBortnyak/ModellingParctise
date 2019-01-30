package com.codecool;

public class Cookbook extends Book{
    String foodkind;
    public Cookbook(String author, String title, int numOfPages, Boolean read) {
        super(author, title, numOfPages, read);
        this.foodkind = foodkind;
    }
}
