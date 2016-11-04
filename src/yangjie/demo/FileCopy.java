package yangjie.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {

  public static void main(String[] args) throws IOException {
    // TODO Auto-generated method stub
    String src = "C:\\Users\\lenovo\\Desktop\\test\\jetTest1\\11111.txt";
    String desr = "C:\\Users\\lenovo\\Desktop\\test\\jetTest2\\11111.txt";

    copyFile(src, desr);

  }

  public static void copyFile(String src, String dest) throws IOException {

    FileInputStream in = new FileInputStream(src);
    File file = new File(dest);

    if (!file.exists()) {
      file.createNewFile();
    }

    FileOutputStream out = new FileOutputStream(file);
    int c;
    byte buffer[] = new byte[1024];
    c = in.read(buffer);
    while (c != -1) {
      for (int i = 0; i < c; i++) {
        out.write(buffer[i]);
      }
    }
    in.close();
    out.close();
  }

}
