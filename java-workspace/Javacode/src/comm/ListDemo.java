package comm;

import java.io.File;
import java.io.FileFilter;

/**
 * 有关目录遍历的操作
 * Author:ywh
 * Date:2019/02/13
 */
public class ListDemo {
    public static void main(String[] args) {
        File file = new File("F:/Java/Test1");
        System.out.println("输出目录中的全部文件");
        for (File f : file.listFiles()) {
            System.out.println(f.getPath());
        }
        System.out.println("目录下所有带.txt");
        for (File d : file.listFiles(new JavaFileFilter(".txt"))) {
            System.out.println("d.getPath()");
        }

        System.out.println("返回其父目录的名字字符串");
        //返回其父目录的名字字符串string
        String c = file.getParent();
        System.out.println(c);

        System.out.println("返回其父目录File对象");
        //返回其父目录File对象
        File u = file.getParentFile();
        for (File a : u.listFiles()) {
            System.out.println(a.getPath());
        }


    }
}

class JavaFileFilter implements FileFilter {

    private String str;

    public JavaFileFilter(String str) {
        this.str = str;
    }

    @Override
    public boolean accept(File pathname) {
        if (!pathname.isDirectory()) return false;
        String name = pathname.getName().toLowerCase();

        if (name.contains(str)) {
            return true;
        } else {
            return false;
        }

    }

}

