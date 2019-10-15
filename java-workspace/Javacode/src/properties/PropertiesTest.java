package properties;

import java.io.*;
import java.util.Properties;

/**
 * @author ywh
 * @date 2019/10/15 19:43
 * @description  Properties属性文件操作
 * 1. 设置属性 : public synchronized Object setProperty(String key, String value)
 * 2. 取得属性 : public String getProperty(String key),如果没有指定的key则返回null
 * 3. 取得属性 : public String getProperty(String key, String defaultValue)，如果没有指定的key则返回默认
 * 值
 */
public class PropertiesTest {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.setProperty("x", "xi");
        System.out.println(properties.getProperty("x")) ;
        System.out.println(properties.getProperty("o","p"));
    }
}
