package com.codecool;

import java.util.List;
import java.util.Scanner;

class Start {
    private XMLParser xml = new XMLParser();
    private List<Book> books = xml.xmlParser();
    private Storage storage = new Storage();

    void start() {
        while (true) {
            int n = Input.menuIput();
            if (n == 1) {
                UI.displayBooks(books);
                start();
            }
            if (n == 2) {
                UI.displayFreeSpace(storage.retSelf(), storage.retDesk(), storage.retSmall());
                start();
            }
            if (n == 3) {
                UI.delRmSubMenu(storage.retSelf(), storage.retDesk(), storage.retSmall());
                add(books);
                start();
            }
            if (n == 4) {
                remove(books);
            }
            if (n == 0) {
                System.exit(0);
            }
            else {
                System.out.println("There is no such option");
                start();
            }
        }
    }

    private void add(List<Book> book) {
        UI.displayBooks(book);
        System.out.println("Enter the ID of a book");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println("Enter where you want to add the book");
        System.out.println("1.Self");
        System.out.println("2.Desk");
        System.out.println("3.Bed Stand");
        System.out.println("4.Back");
        int n2 = Input.subMenuInput();

        if (n2 == 1) {
            if(!storage.checkIfFull(storage.retSelf(),4)){
                System.out.println("Storage is full");
                start();
            }
            else {
                storage.addBookSelf(book.get(n - 1));
                book.remove(n - 1);
            }
        } else if (n2 == 2) {
            if(!storage.checkIfFull(storage.retDesk(),4)){
                System.out.println("Storage is full");
                start();
            }
            else {
                storage.addBooksOnTheDesk(book.get(n - 1));
                book.remove(n - 1);
            }
        } else if (n2 == 3) {
            if(!storage.checkIfFull(storage.retSmall(),1)){
                System.out.println("Storage is full");
                start();
            }
            else {
                storage.addBooksOnTheSmall(book.get(n - 1));
                book.remove(n - 1);
            }
            storage.addBooksOnTheSmall(book.get(n - 1));
            book.remove(n - 1);
        }
        else if(n2 ==0){
            start();
        }
        else {
            System.out.println("There is no such option");
            add(book);
        }

    }

    private void remove(List<Book> books) {
        UI.printStorage(storage.retSelf(), storage.retDesk(), storage.retSmall());
        if (storage.retSelf().size() == 0 && storage.retDesk().size() == 0 && storage.retSmall().size() == 0) {
            System.out.println("Everything is empty");
        } else {
            System.out.println("Enter where you want remove something");
            System.out.println("1.Self");
            System.out.println("2.Desk");
            System.out.println("3.Bed Stand");
            System.out.println("4.Back");
            int n2 = Input.subMenuInput2();
            if (n2 == 1) {
                int in = Input.subMenuInput3();
                storage.addBack(books, storage.retSelf().get(in-1));
                storage.rmSelf(in);

            } else if (n2 == 2) {
                int in = Input.subMenuInput3();
                storage.addBack(books, storage.retDesk().get(in-1));
                storage.rmDesk(in);
            } else if (n2 == 3) {
                int in = Input.subMenuInput3();
                storage.addBack(books, storage.retSmall().get(in-1));
                storage.rmSmall(in);
            }
            else if (n2 == 0){
                start();
            }
            else {
                System.out.println("There is no such option");
                remove(books);
            }
        }
    }
}
