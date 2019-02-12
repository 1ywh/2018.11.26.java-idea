package comm;

import java.io.*;

/**字符输入流
 * Author:ywh
 * Date:2019/02/11
 */
public class ReaderTest {
    public static void main(String[] args) throws IOException {
        File file=new File(File.separator + "F:" + File.separator + "Java" +
                File.separator + "Test1"
                + File.separator + "BB.txt");
        // 2.必须保证文件存在才能进行处理
        if (file.exists()) {
            Reader in = new FileReader(file) ;
            char[] data = new char[1024] ;
            int len = in.read(data) ; // 将数据读取到字符数组中
            String result = new String(data, 0, len) ;
            System.out.println("读取内容【"+result+"】") ;
            in.close();
        }
    }
}
