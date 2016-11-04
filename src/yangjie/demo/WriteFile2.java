package yangjie.demo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class WriteFile2 {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    try {
      //PrintStreamDemo();
      StringBufferDemo();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  //利用PrintStream写文件
  public static void PrintStreamDemo() throws IOException {
    FileOutputStream out = new FileOutputStream(
      "C:\\Users\\lenovo\\Desktop\\test\\aaa.txt");
    PrintStream p = new PrintStream(out);
    for (int i = 0; i < 10; i++)
      p.println("这是第 " + i + "行");
  }

  //2.利用StringBuffer写文件
  public static void StringBufferDemo() throws IOException {
    File file = new File("C:\\Users\\lenovo\\Desktop\\test\\bbb.txt");
    if (!file.exists()) {
      file.createNewFile();
    }
    FileOutputStream out = new FileOutputStream(file, true);
    for (int i = 0; i < 10000; i++) {
      StringBuffer sb = new StringBuffer();
      sb.append("这是第" + i + "行:前面介绍的各种方法都不关用,为什么总是奇怪的问题 ");
      out.write(sb.toString().getBytes("utf-8"));
    }

    out.close();
  }

}
