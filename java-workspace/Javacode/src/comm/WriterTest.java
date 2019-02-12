package comm;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**字符输出流
 * Author:ywh
 * Date:2019/02/11
 */
public class WriterTest {
    public static void main(String[] args) throws IOException {
        File file=new File(File.separator + "F:" + File.separator + "Java" +
                File.separator + "Test1"
                + File.separator + "BB.txt");
        if(!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
        String a="ok!";
        Writer out=new FileWriter(file);
        out.write(a);
        out.close();
    }



}
