package iterator;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * 双向迭代输出，先正向再反向
 * Author:ywh
 * Date:2019/03/23
 */
public class TestListIterator {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>() ;
        list.add("Hello") ;
        list.add("Hello") ;
        list.add("B") ;
        list.add("Bit") ;
        ListIterator<String> iterator=list.listIterator();
        System.out.print("从前向后输出: ") ;
        while (iterator.hasNext()) {
            System.out.print(iterator.next()+"、") ;
        }
        System.out.println("\n从后向前输出: ") ;
        while(iterator.hasPrevious()){
            System.out.println(iterator.previous());
         }
    }
}
