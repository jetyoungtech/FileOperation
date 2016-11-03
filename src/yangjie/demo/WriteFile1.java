package yangjie.demo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteFile1 {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    String s = "Java语言";
    int n = 100;

    //声明流对象
    FileOutputStream fos = null;
    try {
      //创建流对象
      fos = new FileOutputStream(
        "C:\\Users\\lenovo\\Desktop\\新建文件夹\\test\\OutputTestNew.txt");
      //转换为byte数组
      byte[] b1 = s.getBytes();
      //换行符
      byte[] b2 = "\r\n".getBytes();
      byte[] b3 = String.valueOf(n).getBytes();
      //依次写入文件
      try {
        fos.write(b1);
        fos.write(b2);
        fos.write(b3);
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      } finally {
        try {
          fos.close();
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }

    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }

}
