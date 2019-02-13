package comm;

import java.io.*;

/**
 * 文本文件的写入
 * Author:ywh
 * Date:2019/02/13
 */
public class OutputStreamWriterDemo {
    public static void main(String[] args) throws IOException {
        FileOutputStream u = new FileOutputStream("F:/Java/Test1/HH.txt");

        OutputStreamWriter out = new OutputStreamWriter(u, "UTF-8");

        out.write(" UTF-8");

        out.close();
    }

}
