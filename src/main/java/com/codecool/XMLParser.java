package com.codecool;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



class XMLParser {
    List<Book> xmlParser() {
        List<Book> books = new ArrayList<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            try {
                Document doc = builder.parse("src/main/data/books.xml");
                doc.getDocumentElement().normalize();
                Element root = doc.getDocumentElement();
                NodeList allBooks = root.getChildNodes();
                List<Integer> constarray = new ArrayList<>();
                for (int i = 0; i < allBooks.getLength(); i++) {
                    Node booknode = allBooks.item(i);
                    if (booknode.getNodeType() == booknode.ELEMENT_NODE) {
                        NodeList parameters = booknode.getChildNodes();
                        Element nElement = (Element) parameters;
                        NodeList nL = nElement.getElementsByTagName("*");
                        Book book = bookTypeCheck(nL);

                        books.add(book);
                    }
                }

            } catch (SAXException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        return books;

    }

    private Book bookTypeCheck(NodeList nL) throws FileNotFoundException {
        if ((nL.item(0).getTextContent()).equals("CookBook")) {
            String autor = nL.item(1).getTextContent();
            String title = nL.item(2).getTextContent();
            int pages = Integer.valueOf(nL.item(3).getTextContent());
            String foodKind = (nL.item(4).getTextContent());
            Cookbook ret = new Cookbook(autor, title, pages, foodKind);
            return ret;

        }
        if ((nL.item(0).getTextContent()).equals("PopUpBook")) {
            //in progress
            String autor = nL.item(1).getTextContent();
            String title = nL.item(2).getTextContent();
            int pages = Integer.valueOf(nL.item(3).getTextContent());
            Kind anEnum = Kind.valueOf(nL.item(4).getTextContent());
            PopUpBook ret = new PopUpBook(autor, title, pages, anEnum);
            return ret;
        }
        if ((nL.item(0).getTextContent()).equals("Fantasy")) {
            String autor = nL.item(1).getTextContent();
            String title = nL.item(2).getTextContent();
            int pages = Integer.valueOf(nL.item(3).getTextContent());
            String type = (nL.item(4).getTextContent());
            Fantasy ret = new Fantasy(autor, title, pages, type);
            return ret;
        }
        throw new FileNotFoundException("Error with the file reading :(");
    }
}
