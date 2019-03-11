package com.codecool.ui;


import com.codecool.brain.Book;
import com.codecool.brain.Serilizing;
import com.codecool.brain.XMLParser;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main  {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, ClassNotFoundException {
        XMLParser parser = new XMLParser();
        List<Book> books = parser.xmlParser();
        Serilizing ser = new Serilizing(books,null);


        System.out.println(books);

        ser.writeBooks();
        System.out.println(books);
        List<Book> mukodj = ser.readBooks();
        System.out.println(mukodj);
    }
}
