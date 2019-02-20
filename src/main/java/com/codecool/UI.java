package com.codecool;

import java.util.List;


class UI {

    static void displayBooks(List<Book> bookList) {
        for (int i = 0; i < bookList.size(); i++) {
            System.out.println("ID " + (i+1) + "|" + bookList.get(i));

        }

    }

    static void displayMenu() {
        System.out.println("Make your choice");
        System.out.println("1. to display every book ");
        System.out.println("2. to see there is any free place");
        System.out.println("3. if you wanna place a book");
        System.out.println("4. if you wanna remove a book");
        System.out.println("0. to quit");
    }

    static void displayFreeSpace(List<Book> bookSelf, List<Book> desk, List<Book> small) {
        if (bookSelf.size() == 0 ) {
            System.out.println("The book self is empty");
        } else {
            System.out.println("\t" + (5 - bookSelf.size()) + " free place on the self");
        }
        if (desk.size() == 0) {
            System.out.println("The desk is empty");
        } else {
            System.out.println("\t" + (5 - desk.size()) + " free place on the desk");
        }
        if (small.size() == 0) {
            System.out.println("The bed stand is empty");
        } else {
            System.out.println("\t" + (2 - small.size()) + " free place on the bed stand");
        }

    }



    static void printStorage(List<Book> bookSelf, List<Book> desk, List<Book> small) {
        System.out.println("Book self: ");
        if (bookSelf.size() == 0) {
            System.out.println("Empty");
        } else {
            for (int i = 0; i < bookSelf.size(); i++) {
                System.out.println("ID" + (i+1) + "|" + bookSelf.get(i));
            }
        }
        System.out.println();
        System.out.println("Desk: ");
        if (desk.size() == 0) {
            System.out.println("Empty");
        } else {
            for (int i = 0; i < desk.size(); i++) {
                System.out.println("ID" + (i+1)+ "|" +desk.get(i));
            }
        }
        System.out.println();
        System.out.println("Bed stand: ");
        if (small.size() == 0) {
            System.out.println("Empty");
        } else {
            for (int i = 0; i < small.size(); i++) {
                System.out.println("ID"+ (i+1)+ "|" +small.get(i));
            }
        }
    }

    static void delRmSubMenu(List<Book> bookSelf, List<Book> desk, List<Book> small) {
        printStorage(bookSelf, desk, small);

    }
}
