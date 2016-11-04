package yangjie.demo;

import java.io.File;

public class RenameFile {

  public static void main(String[] args) {
    String path = "C:\\Users\\lenovo\\Desktop\\test";
    renameFile(path, "bbb.txt", "ccc.txt");

  }

  public static void renameFile(String path, String oldname, String newname) {

    if (!oldname.equals(newname)) {
      File oldfile = new File(path + "/" + oldname);
      File newfile = new File(path + "/" + newname);
      if (newfile.exists()) {
        System.out.println(newname + "已经存在");
      } else {
        oldfile.renameTo(newfile);
      }
    }
  }

}
