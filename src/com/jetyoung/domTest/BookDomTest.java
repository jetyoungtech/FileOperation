package com.jetyoung.domTest;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class BookDomTest {

  public static void main(String[] args) throws Exception {
    //得到DocumentBuilderFactory
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    //得到DocumentBuilder
    DocumentBuilder db = dbf.newDocumentBuilder();
    //根据指定的XML文件得到Document对象
    Document document = db.parse("src/books.xml");

    //得到第二本书的作者 
    NodeList nl = document.getElementsByTagName("作者");
    //通过节点找
    Node node = nl.item(1);
    System.out.println(node.getFirstChild().getNodeValue());
    //通过元素找
    Element element = (Element) nl.item(1);
    System.out.println(element.getTextContent());
  }

}
