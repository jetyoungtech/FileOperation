package com.jetyoung.Util;

import java.io.FileOutputStream;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class Dom4jUtil {

  //返回Document
  public static Document getDocument() {
    Document document = null;
    try {
      SAXReader reader = new SAXReader();
      document = reader.read("src/books.xml");
    } catch (DocumentException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return document;
  }

  //写回Document到XML文件
  public static void writeDocument2XML(Document document) {
    OutputFormat format = OutputFormat.createPrettyPrint();
    format.setEncoding("UTF-8");
    try {
      XMLWriter writer = new XMLWriter(new FileOutputStream("src/books.xml"), format);
      writer.write(document);
      writer.close();
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

}
