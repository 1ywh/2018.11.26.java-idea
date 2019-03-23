package iterator;

import java.util.*;

/**
 * 迭代器集合输出,删除
 * Author:ywh
 * Date:2019/03/23
 */
public class TestIterator {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("wo");
        list.add("ni");
        list.add("ta");
        System.out.println(list);
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String str = iterator.next();
            if (str.equals("wo")) {
                iterator.remove();
                System.out.println(str);
                continue;
            }
            System.out.println(str);
        }
    }
}
