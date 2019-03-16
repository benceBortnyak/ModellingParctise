package com.codecool.ui;


public class OutPut {

    public static void sendFeedback(String string){
        System.out.println(string);
    }
    static void printWelcomeMessenge(){
        System.out.println("Welcome! \n"+
            "If you have any questions please read the read.me file!");
    }
    static void printMenu(){
        System.out.println(
                "Press the right number\n"+
                    "-------------------------------------------\n" +
                    "1. to Load pre given books\n" +
                "2. to create a new book\n"+
                "3 to create a new storage(by default you have 0 storage)\n"+
                    "4 to display every book\n"+
                    "5 to move a book\n"+
                    "6 to display every storage\n"+
                    "0. to exit"
        );
    }
    static void printExitMenu(){
        System.out.println(
            "Press 1 if you wanna save the state\n"+
            "Press 0 if you don't wanna save(or anything else)"
        );

    }
    static void printNewBook(){
        System.out.println("Choose which kind of you wanna make;\n" +
            "\t 1.Cookbook"+
                "\t 2.Pop up book"+
                "\t 3.Fantasy book"
            );
    }
    static void printBookMenu(){
        System.out.println(
            "The storage limited to the content of the book"+
                "You have to choose the length of the storage"+
                "and the type of the content"
        );
    }
    static void printBookchoice(){
        System.out.println("Press:\n" +
            "1.to create a storage for children\n"+
            "2.to create a storage for teenagers\n"+
            "3.to create a storage for adults"
        );
    }
    static void printCapacity(){
        System.out.println("Enter the capacity of the storage ");
    }
    static void printRmSubMenu(){
        System.out.println("Press\n:" +
            "-------------------------------\n"+
            "1.to move a book to a storage\n"+
            "2.remove a book from a storage\n"+
            "3. to exit to the main menu"
        );
    }

    public static void removeAddBook() {
        System.out.println("Enter the id of a the book");
    }
}
