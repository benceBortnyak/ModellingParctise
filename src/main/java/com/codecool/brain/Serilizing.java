package com.codecool.brain;

import com.codecool.ui.Start;
import com.codecool.ui.UI;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Serilizing{


    List<Book> books;
    List<Storage> storage;

    public Serilizing(List<Book> books, List<Storage> storage) {
        this.books = books;
        this.storage = storage;
    }

    public void writeStorage() throws IOException{
        FileOutputStream inputStream = new FileOutputStream("storage.txt");
        ObjectOutputStream objectIn = new ObjectOutputStream(inputStream);
        objectIn.writeObject(storage);
        objectIn.close();
        inputStream.close();
        UI.sendFeedback("Successfully saved");
    }
    @SuppressWarnings("unchecked")
    public List<Book> readBooks() throws IOException, ClassNotFoundException {
        List<Book> books1 = new ArrayList<>();
        FileInputStream fileInputStream = new FileInputStream(new File("books.txt"));
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        books1 = (List<Book>) objectInputStream.readObject();
        UI.sendFeedback("Successfully loaded");
        return books1;
    }

    public void writeBooks() throws IOException{
        FileOutputStream inputStream = new FileOutputStream("books.txt");
        ObjectOutputStream objectIn = new ObjectOutputStream(inputStream);
        objectIn.writeObject(books);
        objectIn.close();
        inputStream.close();
        UI.sendFeedback("Successfully saved");
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void setStorage(List<Storage> storage) {
        this.storage = storage;
    }
}
