package com.codecool.ui;

import com.codecool.brain.Book;
import com.codecool.brain.BookNotFoundException;
import com.codecool.brain.Home;
import com.codecool.brain.XMLParser;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

class Start {
     void start() throws InterruptedException {
         Home home = new Home();
         OutPut.printWelcomeMessenge();
        while (true) {
            Thread.sleep(1000);
            OutPut.printMenu();
            int menu = Input.menuInput();
            if(menu == 1){
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
            else if(menu == 2){
                //new book
            }
            else if (menu == 3){
                //new storage
            }
            else if(menu == 4){
                //display books
            }
            else if(menu == 5){
                //move a book
            }
            else if(menu == 6){
                //display the storage
            }
            else if(menu == 0){
                OutPut.printExitMenu();
                int quit = Input.quitMenuInput();
                if(quit == 1){
                    home.setStorage(home.getStorage());
                    home.setBooks(home.getBooks());
                }
                else{
                    OutPut.sendFeedback("Bye!");
                    System.exit(0);
                }

            }
            else{
                OutPut.sendFeedback("Wrong input");
            }

        }

    }
}
