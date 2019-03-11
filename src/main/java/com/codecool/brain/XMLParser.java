package com.codecool.brain;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class XMLParser {
    public List<Book> xmlParser() throws SAXException,IOException,ParserConfigurationException,BookNotFoundException{
        List<Book> books = new ArrayList<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document doc = builder.parse("books.xml");
        doc.getDocumentElement().normalize();
        Element root = doc.getDocumentElement();
        NodeList allBooks = root.getChildNodes();
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
        return books;
    }

    private Book bookTypeCheck(NodeList nL) throws BookNotFoundException{
        if ((nL.item(0).getTextContent()).equals("CookBook")) {
            List<String> contents = new ArrayList<>();
            String autor = nL.item(1).getTextContent();
            String title = nL.item(2).getTextContent();
            int pages = Integer.valueOf(nL.item(3).getTextContent());
            String foodKind = (nL.item(4).getTextContent());
            NodeList nodes = nL.item(5).getChildNodes();
            for (int i = 0; i < nodes.getLength() ; i++) {
                String content = nodes.item(i).getTextContent();
                contents.add(content);
            }
            return new Cookbook(autor, title, pages,contents,foodKind);
        }
        if ((nL.item(0).getTextContent()).equals("PopUpBook")) {
            List<String> contents = new ArrayList<>();
            String autor = nL.item(1).getTextContent();
            String title = nL.item(2).getTextContent();
            int pages = Integer.valueOf(nL.item(3).getTextContent());
            Kind anEnum = Kind.valueOf(nL.item(4).getTextContent());
            NodeList nodes = nL.item(5).getChildNodes();
            for (int i = 0; i < nodes.getLength() ; i++) {
                String content = nodes.item(i).getTextContent();
                contents.add(content);
            }
            return new PopUpBook(autor, title, pages, contents ,anEnum);

        }
        if ((nL.item(0).getTextContent()).equals("Fantasy")) {
            List<String> contents = new ArrayList<>();
            String autor = nL.item(1).getTextContent();
            String title = nL.item(2).getTextContent();
            int pages = Integer.valueOf(nL.item(3).getTextContent());
            String type = (nL.item(4).getTextContent());
            NodeList nodes = nL.item(5).getChildNodes();
            for (int i = 0; i < nodes.getLength() ; i++) {
                String content = nodes.item(i).getTextContent();
                contents.add(content);
            }
            return new Fantasy(autor, title, pages, contents,type);

        }
        throw new BookNotFoundException();
    }
}
