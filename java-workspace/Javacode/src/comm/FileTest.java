package comm;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * Author:ywh
 * Date:2018/12/09
 * 文件操作类
 */
public class FileTest {

    private static File file;

    //1、判断文件存在与否，存在删除不存在创建
    public static void code1() throws IOException {
        //separator 用来决定路径分隔符"/"
        File file1 = new File("F:" + File.separator + "Test1");
        if (file1.exists()) {
            file1.delete();
        } else {
            file1.createNewFile();
        }
    }

    //2、目录的操作，Test1和Test是创建的目录，Ts是目录下的文件
    //取得父路径public String getParent()
    //取得父File对象 public File getParentFile()：
    //创造父类的目录 public boolean mkdirs()
    public static void code2() throws IOException {

        //有多少级父目录就创造多少级，separator由不同操作系统下的JVM来决定到底是哪个杠杠
        File file = new File("F:" + File.separator + "Java" + File.separator + "Test1"
                + File.separator + "Test2" + File.separator + "Ts");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        if (file.exists()) {
            file.delete();
        } else {
            file.createNewFile();
        }
    }

    //3、打印文件的信息
    public static void code3() throws IOException {
        File file = new File("F:" + File.separator + "Java" + File.separator + "Test1"
                + File.separator + "Test2" + File.separator + "Tss");
        if (!file.exists()) {
            file.createNewFile();
        }
        if (file.exists() && file.isFile()) {
            System.out.println("文件大小" + file.length());
            System.out.println("文件名字" + file.getName());
            System.out.println("最后一次修改日期：" + new Date(file.lastModified()));
        }
    }

    //4、列出该目录下中的全部内容
    public static void code4() throws IOException {
        //写入一个目录
        File file = new File("F:" + File.separator + "Java" + File.separator + "Test1");
        //保证是个目录且存在
        if (file.exists() && file.isDirectory()) {
            //列出目录的全部内容，只能够列出本目录中的第一级信息。
            File[] file1 = file.listFiles();
            for (File file2 : file1) {
                System.out.println(file2);
            }
        }
    }

    //5、递归遍历打印目录底下的所有文件
    public static void code5(File file) {
        if (file.isDirectory()) {
            File[] file1 = file.listFiles();//给定的file对象是目录
            if (file1 != null) {
                for (File file2 : file1) {
                    code5(file2);
                }
            }
        } else {
            System.out.println(file);
        }
    }

    public static void main(String[] args) throws IOException {
//        code1();
//        code2();
//        code3();
//        code4();
//        //1.
//        File file = new File("F:" + File.separator + "Java" + File.separator + File.separator + "Test1");
//        code5(file);
       // 2.开启子线程进行耗时运算
        new Thread(() -> {
            File file = new File("F:" + File.separator + "Java" + File.separator + "Test1");
            code5(file);
        }, "输出线程").start();
        System.out.println("开始");
    }

}
