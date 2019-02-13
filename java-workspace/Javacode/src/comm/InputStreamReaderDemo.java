package comm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 文本文件的读取
 * Author:ywh
 * Date:2019/02/13
 */
public class InputStreamReaderDemo {

    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(new FileInputStream("F:/Java/Test1/HH.txt"), "UTF-8");
        int i;
        while ((i = in.read()) != -1) {
            System.out.print((char) i);
        }
        in.close();
    }
}
