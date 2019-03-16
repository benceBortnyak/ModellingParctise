package com.codecool.ui;

import com.codecool.brain.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Start {
    void start() throws InterruptedException {
        List<Book> books = new ArrayList<>();
        List<Storage> storages = new ArrayList<>();
        Home home = new Home(books, storages);

        OutPut.printWelcomeMessenge();
        while (true) {
            Thread.sleep(1000);
            OutPut.printMenu();
            int menu = Input.intInput();
            if (menu == 1) {
                loadBooks(home);
            } else if (menu == 2) {
                createNewBook(home);
            } else if (menu == 3) {
                createNewStorage(home);
            } else if (menu == 4) {
                displayBooks(home);
            } else if (menu == 5) {
                //move a book
            } else if (menu == 6) {
                displayStorage(home);
            } else if (menu == 0) {
                OutPut.printExitMenu();
                int quit = Input.quitMenuInput();
                if (quit == 1) {
                    try {
                        home.writeStorage();
                        home.writeBooks();
                    } catch (IOException e) {
                        OutPut.sendFeedback("No such file");
                    }
                } else {
                    OutPut.sendFeedback("Bye!");
                    System.exit(0);
                }
            } else {
                OutPut.sendFeedback("Wrong input");
            }

        }

    }

    private void loadBooks(Home home) {
        XMLParser parser = new XMLParser();
        try {
            List<Book> books = parser.xmlParser();
            home.setBooks(books);
            OutPut.sendFeedback("Books from the file loaded successfully");
        } catch (SAXException e) {
            OutPut.sendFeedback("Error with the file reading :( ");
        } catch (IOException e) {
            OutPut.sendFeedback("No such a file please read the read.me file :(");
        } catch (ParserConfigurationException e) {
            OutPut.sendFeedback("Config error :(");
        } catch (BookNotFoundException e) {
            OutPut.sendFeedback("Can't read a book");
        }
    }

    private void createNewBook(Home home) {
        OutPut.printNewBook();

        int in = Input.intInput();
        if (in == 1) {

            String autor = Input.autorInPut();
            String title = Input.titleInPut();
            int page = Input.pageInput();
            String kind = Input.foodKindInPut();
            List<String> cont = Input.content();
            Cookbook cookbook = new Cookbook(autor, title, page, cont, kind);
            home.addBook(cookbook);
        } else if (in == 2) {
            String autor = Input.autorInPut();
            String title = Input.titleInPut();
            int page = Input.pageInput();
            int kindInt = Input.kindInput();
            Kind kind;
            if (kindInt == 1) {
                kind = Kind.valueOf("CITY");
            } else if (kindInt == 2) {
                kind = Kind.valueOf("FAIRYTALE");
            } else {
                kind = null;
            }

            List<String> cont = Input.content();


            PopUpBook pop = new PopUpBook(autor, title, page, cont, kind);
            List<Book> books = home.getBooks();
            books.add(pop);
            home.setBooks(books);
        } else if (in == 3) {
            String autor = Input.autorInPut();
            String title = Input.titleInPut();
            int page = Input.pageInput();
            String sub = Input.typeInput();
            List<String> cont = Input.content();


            Fantasy fantasy = new Fantasy(autor, title, page, cont, sub);
            List<Book> books = home.getBooks();
            books.add(fantasy);
            home.setBooks(books);
        } else {
            OutPut.sendFeedback("Wrong input");
        }


    }

    private void createNewStorage(Home home) {
        OutPut.printBookMenu();
        int type = Input.storageTypeInput();
        if (type == 1) {
            List<Book> books = new ArrayList<>();
            int n = Input.storageCapacityInput();
            Storage childStorage = new ChildStorage(books, n);
            List<Storage> setList = home.getStorage();
            setList.add(childStorage);
            home.setStorage(setList);
        } else if (type == 2) {
            List<Book> books = new ArrayList<>();
            int n = Input.storageCapacityInput();
            Storage teenStorage = new TeenStorage(books, n);
            List<Storage> setList = home.getStorage();
            setList.add(teenStorage);
            home.setStorage(setList);
        } else if (type == 3) {
            List<Book> books = new ArrayList<>();
            int n = Input.storageCapacityInput();
            Storage AdultStorage = new ChildStorage(books, n);
            List<Storage> setList = home.getStorage();
            setList.add(AdultStorage);
            home.setStorage(setList);
        }
    }

    private void displayBooks(Home home) {
        List<Book> books = home.getBooks();
        for (int i = 0; i < books.size(); i++) {
            System.out.println("ID " + (i + 1) + " | " + books.get(i));
        }
    }

    private void displayStorage(Home home) {
        List<Storage> storage = home.getStorage();
        for (int i = 0; i <storage.size() ; i++) {
            System.out.println("ID " +(i+1) +" | " + storage.get(i));
        }
    }

    private void moveBook(Home home) {
        while (true) {
            OutPut.printRmSubMenu();
            int input = Input.subMenuInput();
            if(input == 1){
                displayBooks(home);
                List<Book> books = home.getBooks();
                int rmIndex = Input.rmBookFromList(books);
                Book book = books.get(rmIndex);
                books.remove(rmIndex);
                home.setBooks(books);


            }
            else if(input == 2){

            }
            else if(input ==3){
                break;
            }

        }

    }
}
