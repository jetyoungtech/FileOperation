package yangjie.demo;

import java.io.File;
import java.io.IOException;

public class FileOper {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    //this is for gitHub test !
    File f1 = new File("C:\\Users\\lenovo\\Desktop\\新建文件夹\\test"); //绝对路径
    File f2 = new File("test1.txt"); //相对路径
    File f3 = new File("C:\\Users\\lenovo\\Desktop\\新建文件夹\\test\\file.txt"); //文件夹
    File f4 = new File("d:\\test\\", "1.txt");

    //创建文件

    try {
      boolean flag = f3.createNewFile();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    System.out.println(f3.exists()); //判断文件是否存在
    System.out.println(f3.getAbsolutePath()); //获得文件的绝对路径  
    System.out.println(f3.getName()); //获得文件名
    System.out.println(f3.getPath());
    System.out.println(f3.getParent()); //获得父路径
    System.out.println(f3.isDirectory()); //判断是否是目录
    System.out.println(f3.isFile()); //判断是否是文件
    System.out.println(f3.length()); //获得文件长度

    //获得当前文件夹下所有文件和文件夹名称
    String[] s = f1.list();
    for (int i = 0; i < s.length; i++) {
      System.out.println(s[i]);
    }

    //获得文件对象
    File[] f5 = f1.listFiles();
    for (int i = 0; i < f5.length; i++) {
      System.out.println(f5[i]);
    }

    //创建文件夹
    File f6 = new File("C:\\Users\\lenovo\\Desktop\\新建文件夹\\test\\fileFoder");
    //boolean flag = f6.mkdir();
    boolean flag1 = f6.mkdirs();
    //System.out.println(flag);
    System.out.println(flag1);

    //修改文件名
    File f7 = new File("C:\\Users\\lenovo\\Desktop\\新建文件夹\\test\\fileFoder\\a.txt");
    boolean b2 = f3.renameTo(f7);
    System.out.println(b2);

  }
}
