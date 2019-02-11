package comm;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**OutputStream类
 * Author:ywh
 * Date:2019/02/11
 */
public class OutputStreamTest {
    public static void main(String[] args) throws Exception {

        File file=new File(File.separator + "F:" + File.separator + "Java" +
                File.separator + "Test1"
                + File.separator + "HH.txt");

        //如果父类目录不存在创建多级目录
        if(!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
        // OutputStream是一个抽象类，所以需要通过子类进行实例化
        // 此时只能操作File类
        OutputStream output1=new FileOutputStream(file);

        //追加接收File类（追加）：
        OutputStream output=new FileOutputStream(file,true);

        // 要求输出到文件的内容
        String message="hello java !!!";

        // 1.将全部内容变为字节数组
        output.write(message.getBytes());


        //2.将部分内容变为字节数组
       output.write(message.getBytes(),0,5);

        output.close();
    }


}
