package com.codecool.brain;
import com.codecool.ui.OutPut;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Home{

    private List<Book> books;
    private List<Storage> storage;

    public Home(List<Book> books,List<Storage> storage) {
        this.books = books;
        this.storage = storage;
    }


    public void writeStorage() throws IOException{
        FileOutputStream inputStream = new FileOutputStream("storage.ser");
        ObjectOutputStream objectIn = new ObjectOutputStream(inputStream);
        objectIn.writeObject(storage);
        objectIn.close();
        inputStream.close();
        OutPut.sendFeedback("Successfully saved");
    }
    @SuppressWarnings("unchecked")
    public List<Storage> readStorage() throws IOException, ClassNotFoundException {
        List<Storage> books1 = new ArrayList<>();
        FileInputStream fileInputStream = new FileInputStream(new File("storage.ser"));
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        books1 = (List<Storage>) objectInputStream.readObject();
        OutPut.sendFeedback("Successfully loaded");
        return books1;
    }

    @SuppressWarnings("unchecked")
    public List<Book> readBooks() throws IOException, ClassNotFoundException {
        List<Book> books1 = new ArrayList<>();
        FileInputStream fileInputStream = new FileInputStream(new File("books.ser"));
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        books1 = (List<Book>) objectInputStream.readObject();
        OutPut.sendFeedback("Successfully loaded");
        return books1;
    }

    public void writeBooks() throws IOException{
        FileOutputStream inputStream = new FileOutputStream("books.ser");
        ObjectOutputStream objectIn = new ObjectOutputStream(inputStream);
        objectIn.writeObject(books);
        objectIn.close();
        inputStream.close();
        OutPut.sendFeedback("Successfully saved");
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void setStorage(List<Storage> storage) {
        this.storage = storage;
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<Storage> getStorage() {
        return storage;
    }
    public void addBook(Book book){
        this.books.add(book);
    }

    @Override
    public String toString() {
        return "Home{" +
            "books=" + books +
            '}';
    }
}
