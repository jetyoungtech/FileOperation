package com.jetyoung.saxXMLTest;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import com.jetyoung.domain.Book;

public class SaxTest2 {

  public static void main(String[] args) throws Exception {
    //1.得到 XMLReader
    SAXParser sp = SAXParserFactory.newInstance().newSAXParser();

    //2.得到XMLReader
    XMLReader reader = sp.getXMLReader();

    //final ArrayList<Book> list = new ArrayList<Book>();
    final List<Book> list = new ArrayList<Book>();

    //3.设置reader的内容解析器
    reader.setContentHandler(new DefaultHandler() {
      Book book = null;

      String node = null;

      public void startElement(String uri, String localName, String qName,
        Attributes attributes) throws SAXException {
        if ("书".equals(qName)) {
          book = new Book();
        }
        node = qName;
      }

      public void endElement(String uri, String localName, String qName)
        throws SAXException {
        if ("书".equals(qName)) {
          list.add(book);
          book = null;
        }
        node = null;
      }

      public void characters(char[] ch, int start, int length) throws SAXException {
        //        if ("书名".equals(node)) {
        //          book.setName(new String(ch, start, length));
        //        } else if ("作者".equals(node)) {
        //          book.setAuthor(new String(ch, start, length));
        //        } else {
        //          book.setPrice(Double.parseDouble(new String(ch, start, length)));
        //        }
        //      }
        if ("书名".equals(node))
          book.setName(new String(ch, start, length));
        if ("作者".equals(node))
          book.setAuthor(new String(ch, start, length));
        if ("售价".equals(node))
          book.setPrice(Double.parseDouble(new String(ch, start, length)));
      }

    });

    //4.转换
    reader.parse("src/books.xml");

    //5.输出
    for (Book b : list) {
      System.out.println(b);
    }

  }

}
