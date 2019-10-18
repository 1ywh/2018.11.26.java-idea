package properties;

import java.util.Properties;

/**
 * Author:ywh
 * Date:2019/03/28
 */
public class TestProperties {
    public static void main(String[] args) {
        Properties p=new Properties();
        p.setProperty("l","r");
        System.out.println(p.getProperty("r"," o "));
    }
}
