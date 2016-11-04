package yangjie.demo;

import java.io.File;

public class MoveDirectory {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    String oldpath = "C:\\Users\\lenovo\\Desktop\\test\\jetTest1";
    String newpath = "C:\\Users\\lenovo\\Desktop\\test\\jetTest2";
    changeDirectory("aaaaa.txt", oldpath, newpath, true);
  }

  public static void changeDirectory(String filename, String oldpath,
    String newpath, boolean cover) {
    if (!oldpath.equals(newpath)) {
      File oldFile = new File(oldpath + "/" + filename);
      File newFile = new File(newpath + "/" + filename);
      if (newFile.exists()) {
        if (cover) {
          oldFile.renameTo(newFile);
        } else {
          System.out.println("文件已经存在");
        }
      } else {
        oldFile.renameTo(newFile);
      }
    }
  }

}
