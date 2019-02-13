package comm;

import java.io.FileReader;
import java.io.IOException;

/**文件内容读取
 * Author:ywh
 * Date:2019/02/13
 */
public class FileReaderDemo {
    public static void main(String[] args) throws IOException {
        FileReader e = new FileReader("F:/Java/Test1/HH.txt");
        int ch;
        while ((ch = e.read()) != -1) {
            System.out.print((char) ch);
        }
        e.close();
    }
}