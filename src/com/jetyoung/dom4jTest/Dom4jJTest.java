package com.jetyoung.dom4jTest;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.junit.Test;

import com.jetyoung.Util.Dom4jUtil;

public class Dom4jJTest {

  @Test
  public void test1() {
    //1.得到Document
    Document docu = Dom4jUtil.getDocument();
    //2.得到根结点
    Element root = docu.getRootElement();
    //3.找到第二本书
    List list = root.elements("书");
    Element book = (Element) list.get(1);
    //4.着第二本书的作者
    Element author = book.element("作者");
    //5.找作者的文本
    System.out.println(author.getText());
  }

  //2.遍历所有节点 
  @Test
  public void test2() {
    //1.得到Document
    Document docu = Dom4jUtil.getDocument();
    //2.得到根结点
    Element root = docu.getRootElement();
    //3.遍历
    treeWalk(root);
  }

  public void treeWalk(Element element) {
    System.out.println(element.getName());
    for (int i = 0; i < element.nodeCount(); i++) {
      Node node = element.node(i);
      if (node instanceof Element) {
        treeWalk((Element) node);
      }
    }
  }

  @Test
  //修改某个元素节点的主体内容 
  public void test3() {
    //1.得到Document
    Document docu = Dom4jUtil.getDocument();
    //2.得到根结点
    Element root = docu.getRootElement();
    //3.找到第一本书
    List list = root.elements("书");
    Element book = (Element) list.get(1);
    //4.找到售价
    Element price = book.element("售价");
    //5.修改售价
    price.setText("300");
    //6.写回
    Dom4jUtil.writeDocument2XML(docu);
  }

  @Test
  //向指定元素节点中增加子元素节点 在第二本书的子结点中添加一个批发价
  public void test4() {
    //1.得到Document
    Document docu = Dom4jUtil.getDocument();
    //2.得到根结点
    Element root = docu.getRootElement();
    //3.找到第二本书
    List list = root.elements("书");
    Element book = (Element) list.get(1);
    //4.追加一个批发价
    book.addElement("批发价").setText("20000");
    //6.写回
    Dom4jUtil.writeDocument2XML(docu);
  }

  @Test
  //向指定元素节点上增加同级元素节点  在第一本书的售价前面，添加一个内部价
  public void test5() {
    //1.得到Document
    Document docu = Dom4jUtil.getDocument();
    //2.得到根结点
    Element root = docu.getRootElement();
    //3.找到第二本书
    List list = root.elements("书");
    Element book = (Element) list.get(1);
    //4.添加内部价
    Element innerPriceNode = DocumentHelper.createElement("内部价");
    innerPriceNode.setText("200");
    book.elements().add(2, innerPriceNode);
    //6.写回
    Dom4jUtil.writeDocument2XML(docu);
  }

  @Test
  //删除指定元素节点  删除第一本书的内部价结点
  public void test6() {
    //1.得到Document
    Document docu = Dom4jUtil.getDocument();
    //2.得到根结点
    Element root = docu.getRootElement();
    //3.找到第二本书
    List list = root.elements("书");
    Element book = (Element) list.get(1);
    //4.删除内部价
    Element innerPrice = book.element("内部价");
    book.remove(innerPrice);
    //6.写回
    Dom4jUtil.writeDocument2XML(docu);
  }

  @Test
  //操作XML文件属性  在第二本书的书结点中，添加一个bookid属性
  public void test7() {
    //1.得到Document
    Document docu = Dom4jUtil.getDocument();
    //2.得到根结点
    Element root = docu.getRootElement();
    //3.找到第二本书
    List list = root.elements("书");
    Element book = (Element) list.get(1);
    //4.设置属性
    book.addAttribute("bookid", "isbsb-111");

    //6.写回
    Dom4jUtil.writeDocument2XML(docu);
  }
}
