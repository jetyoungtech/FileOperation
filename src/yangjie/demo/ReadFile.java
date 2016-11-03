package yangjie.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 使用FileInputStream读取文件
 */
public class ReadFile {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    FileInputStream fis = null;
    try {
      //声明与创建流对象
      fis = new FileInputStream("C:\\Users\\lenovo\\Desktop\\新建文件夹\\test\\test1.txt");
      //读取数据，并将读取到的数据存储到数组中
      byte[] data = new byte[1024]; //数据存储的数组
      int i = 0; //当前下标
      //读取流中的第一个字节数据
      try {
        int n = fis.read();
        while (n != -1) {
          //将有效数据存储到数组中
          data[i] = (byte) n;
          i++;
          n = fis.read();
        }
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }

      String s = new String(data, 0, i);
      //输出字符串
      System.out.println(s);

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } finally {
      try {
        fis.close();
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }

  }

}
