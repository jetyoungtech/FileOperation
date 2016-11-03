package yangjie.demo;

import java.io.File;

public class FileOperDemo1 {

  public static void main(String[] args) {
    File f = new File("C:\\Users\\lenovo\\Desktop\\新建文件夹\\test");
    printAllFile(f);
    File f1 = new File("C:\\Users\\lenovo\\Desktop\\新建文件夹\\test\\aaa");
    deleteAll(f1);

  }

  /**
   * 打印f路径下所有的文件和文件夹
   * @param f 文件对象
  */

  public static void printAllFile(File f) {
    //打印当前文件名
    System.out.println(f.getName());
    if (f.isDirectory()) {
      File[] fList = f.listFiles();
      for (int i = 0; i < fList.length; i++) {
        printAllFile(fList[i]);
      }
    }
  }

  /**
   * 删除对象f下的所有文件和文件夹
   * @param f 文件对象
  */

  public static void deleteAll(File f) {
    if (f.isFile()) {
      f.delete();
    } else {
      File[] fList = f.listFiles();
      for (int i = 0; i < fList.length; i++) {
        deleteAll(fList[i]);
      }
      f.delete();
    }
  }

}
