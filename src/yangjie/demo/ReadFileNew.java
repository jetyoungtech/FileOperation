package yangjie.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadFileNew {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    FileInputStream fis = null;
    try {
      fis = new FileInputStream("C:\\Users\\lenovo\\Desktop\\新建文件夹\\test\\test1.txt");
      byte[] data = new byte[1024];
      try {
        int i = fis.read(data);
        String s = new String(data, 0, i);
        System.out.println(s);
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }

    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
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
