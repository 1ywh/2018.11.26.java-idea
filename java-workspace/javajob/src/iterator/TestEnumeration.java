package iterator;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

/**
 * 集合输出enumeration方法
 * Author:ywh
 * Date:2019/03/23
 */
public class TestEnumeration {
    public static void main(String[] args) {
        Vector<String> vector=new Vector<>();
        vector.add("wo");
        vector.add("ni");
        vector.add("ta");
        Enumeration<String> iterator=vector.elements();
        while(iterator.hasMoreElements()){
            System.out.println(iterator.nextElement());
        }
    }
}
