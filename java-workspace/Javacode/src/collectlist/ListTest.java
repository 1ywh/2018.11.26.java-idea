package collectlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author:ywh
 * Date:2019/02/16
 */
public class ListTest {
    public static void main(String[] args) {
        //此时集合只能保存String类型
        List<String> list = new ArrayList<>();
        //可以存放重复数据
        System.out.println(list.size() + "、" + list.isEmpty());
        list.add("Hello");
        list.add("Hello");
        list.add("java");
        System.out.println(list);
        System.out.println(list.size() + "、" + list.isEmpty());
        System.out.println(list.remove("Hello"));
        System.out.println(list.contains("java"));
        System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        //会产生 java.lang.ClassCastException
        //  System.out.println(Arrays.toString(result));
        //  ArrayList[] result = (ArrayList[]) list.toArray();
        Object[] r = list.toArray();
        System.out.println(Arrays.toString(r));

    }
}
