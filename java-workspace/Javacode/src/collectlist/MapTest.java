package collectlist;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Author:ywh
 * Date:2019/02/15
 */
public class MapTest {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        //向Map中追加元素
        map.put(1, "hello");
       // key重复
        map.put(1,"hello");
        map.put(2,"hello");
        map.put(3,"java");
        map.put(4,"hello");
        System.out.println(map);
        // 根据key取得value
        System.out.println(map.get(2));
        // 查找不到返回null
        System.out.println(map.get(7));
        // 取得Map中所有的key信息,key不能重复
        Set<Integer> set=map.keySet();
        Iterator<Integer> iterator=set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
