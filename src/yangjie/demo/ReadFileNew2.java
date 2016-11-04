package yangjie.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadFileNew2 {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    try {
      System.out
        .println(FileInputStreamDemo("C:\\Users\\lenovo\\Desktop\\test\\jetTest2\\aaaaa.txt"));
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }

  public static String FileInputStreamDemo(String path) throws IOException {
    File file = new File(path);
    if (!file.exists() || file.isDirectory())
      throw new FileNotFoundException();
    FileInputStream fis = new FileInputStream(file);
    byte[] buf = new byte[1024];
    StringBuffer sb = new StringBuffer();
    while ((fis.read(buf)) != -1) {
      sb.append(new String(buf));
      buf = new byte[1024];//重新生成，避免和上次读取的数据重复
    }
    return sb.toString();
  }

}
