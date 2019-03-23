package iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * 集合输出foreach方法
 * Author:ywh
 * Date:2019/03/23
 */
public class TestForeach {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("wo");
        list.add("ni");
        list.add("ta");
        System.out.println(list);
        for(String a:list){
            System.out.println(a);
        }
    }
}
