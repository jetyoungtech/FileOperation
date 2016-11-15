package com.jetyoung.Util;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

public class DomUtil {

  public static Document getDocument() throws Exception {

    //得到DocumentBuilderFactory
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    //得到DocumentBuilder
    DocumentBuilder db = dbf.newDocumentBuilder();
    //根据指定的XML文件得到Document对象
    Document document = db.parse("src/books.xml");

    return document;
  }

  public static void writeDocument2XML(Document doc) throws Exception,
    TransformerFactoryConfigurationError {
    Transformer tf = TransformerFactory.newInstance().newTransformer();
    tf.transform(new DOMSource(doc), new StreamResult("src/books.xml "));

  }

}
