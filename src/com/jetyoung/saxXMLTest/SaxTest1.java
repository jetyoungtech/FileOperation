package com.jetyoung.saxXMLTest;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxTest1 {

  public static void main(String[] args) throws ParserConfigurationException,
    SAXException, IOException {
    // TODO Auto-generated method stub
    SAXParser sp = SAXParserFactory.newInstance().newSAXParser();
    sp.parse("src/books.xml", new DefaultHandler() {
      public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println(new String(ch, start, length));

      }

      public void startDocument() throws SAXException {
        // TODO Auto-generated method stub
        System.out.println("Document Start");
      }

      public void startElement(String uri, String localName, String qName,
        Attributes attributes) throws SAXException {
        System.out.println("Element Start");
      }

      public void endDocument() throws SAXException {
        System.out.println("Document end");
      }

      public void endElement(String uri, String localName, String qName)
        throws SAXException {
        System.out.println("Document end");
      }
    });
  }

}
