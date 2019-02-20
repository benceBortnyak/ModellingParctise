package com.codecool;

import java.util.ArrayList;
import java.util.List;

class Storage {
    private List<Book> bookSelf = new ArrayList<>();//max 5
    private List<Book> booksOnTheDesk = new ArrayList<>();//max 5
    private List<Book> booksOnTheSmall = new ArrayList<>();//max 2

    void addBookSelf(Book book){
        bookSelf.add(bookSelf.size(), book);
    }
    void addBooksOnTheDesk(Book book){
        booksOnTheDesk.add(booksOnTheDesk.size(), book);
    }
    void addBooksOnTheSmall(Book book){
        booksOnTheSmall.add(booksOnTheSmall.size(),book);
    }
    List<Book> retSelf(){
        return bookSelf;
    }
    List<Book> retDesk(){
        return booksOnTheDesk;
    }
    List<Book> retSmall(){
        return booksOnTheSmall;
    }
    void rmSelf(int index){
        bookSelf.remove(index-1);
    }
    void rmDesk(int index){
        booksOnTheDesk.remove(index-1);
    }
    void rmSmall(int index){
        booksOnTheSmall.remove(index-1);
    }
    void addBack(List<Book> books, Book book ){
        books.add(book);

    }
    boolean checkIfFull(List<Book> storage, int capacity){
        if(storage.size() > capacity){
            return false;
        }
        else {
            return true;
        }
    }
}
