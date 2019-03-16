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
        try {
            home.readBooks();
            home.readBooks();
        } catch (IOException e) {
            System.out.println("Failed to load the last state(FILE NOT FOUND)");
        } catch (ClassNotFoundException e) {
            System.out.println("Unexpected error occurred");
        }
        OutPut.printWelcomeMessenge();
        while (true) {
            Thread.sleep(1000);
            OutPut.printMenu();
            int menu = Input.intInput(-1, 7);
            if (menu == 1) {
                loadBooks(home);
            } else if (menu == 2) {
                createNewBook(home);
            } else if (menu == 3) {
                createNewStorage(home);
            } else if (menu == 4) {
                displayBooks(home);
            } else if (menu == 5) {
                moveBook(home);
            } else if (menu == 6) {
                displayStorage(home);
            } else if (menu == 0) {
                OutPut.printExitMenu();
                int quit = Input.quitMenuInput(0, 2);
                if (quit == 1) {
                    try {
                        home.writeStorage();
                        home.writeBooks();
                        System.exit(0);
                    } catch (IOException e) {
                        OutPut.sendFeedback("No such file");
                        System.exit(0);
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
        int in = Input.intInput(0, 4);
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
            Storage childStorage = new Storage("child", books, n);
            List<Storage> setList = home.getStorage();
            setList.add(childStorage);
            home.setStorage(setList);
        } else if (type == 2) {
            List<Book> books = new ArrayList<>();
            int n = Input.storageCapacityInput();
            Storage teenStorage = new Storage("teen", books, n);
            List<Storage> setList = home.getStorage();
            setList.add(teenStorage);
            home.setStorage(setList);
        } else if (type == 3) {
            List<Book> books = new ArrayList<>();
            int n = Input.storageCapacityInput();
            Storage AdultStorage = new Storage("adult", books, n);
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
        for (int i = 0; i < storage.size(); i++) {
            System.out.println("ID " + (i + 1) + " | " + storage.get(i));
        }
    }

    private void displayBooks(List<Book> books) {
        for (int i = 0; i < books.size(); i++) {
            System.out.println("ID " + (i + 1) + " | " + books.get(i));
        }
    }

    private void moveBook(Home home) {
        while (true) {
            OutPut.printRmSubMenu();
            int input = Input.subMenuInput();
            if (input == 1) {
                displayBooks(home);
                List<Book> books = home.getBooks();
                int rmIndex = Input.rmBookFromList(books);
                Book book = books.get(rmIndex);
                books.remove(rmIndex);
                home.setBooks(books);
                displayStorage(home);
                List<Storage> storages = home.getStorage();
                int addIndex = Input.addBookToStorage(home.getStorage());
                Storage storage = storages.get(addIndex);
                List<Book> books1 = storage.getStorage();

                try {
                    if (typeCheck(book, storage)) {
                        if (!fullCheck(storage)) {
                            books1.add(book);
                            storage.setStorage(books1);
                        } else {
                            throw new StorageIsFullException();
                        }
                    } else {
                        throw new WrongTypeException();
                    }
                } catch (WrongTypeException e) {
                    OutPut.sendFeedback("Wrong type of book/storage");
                    break;
                } catch (StorageIsFullException e) {
                    OutPut.sendFeedback("Storage is full");
                    break;
                }
            } else if (input == 2) {
                displayStorage(home);

                int chooseStorage = Input.chooseStorage(home);
                Storage storage = home.getStorage().get(chooseStorage);
                displayBooks(storage.getStorage());
                int chooseBookInTheStorage = Input.chooseBookInTheStorage(storage.getStorage());
                Book book = storage.getStorage().get(chooseBookInTheStorage);
                storage.getStorage().remove(chooseBookInTheStorage);
                List<Book> books = home.getBooks();
                books.add(book);
                home.setBooks(books);
                OutPut.sendFeedback("Book removed");
            } else if (input == 3) {
                break;
            }
        }
    }


    private boolean typeCheck(Book book, Storage storage) {
        List<String> bookContent = book.getContent();
        String storageContent = storage.getType();

        for (int i = 0; i < bookContent.size(); i++) {
            if (bookContent.get(i).equals(storageContent)) {
                return true;
            }
        }
        return false;
    }

    private boolean fullCheck(Storage storage) {
        int capacity = storage.getCapacity();
        List<Book> storageStorage = storage.getStorage();
        return (capacity == storageStorage.size());
    }
}
