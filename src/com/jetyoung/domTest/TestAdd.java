package com.jetyoung.domTest;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.jetyoung.Util.DomUtil;

public class TestAdd {

  public static void main(String[] args) throws Exception {

    Document document = DomUtil.getDocument();
    //在第二本书的售价后面添加一个批发价节点 
    //创建一个新的节点
    Element element = document.createElement("批发价");
    element.setTextContent("800");

    //找到第二本书
    NodeList nodeList = document.getElementsByTagName("书");
    Element node = (Element) nodeList.item(1);
    //搞关系
    node.appendChild(element);
    //写回到XML
    DomUtil.writeDocument2XML(document);
  }

}
