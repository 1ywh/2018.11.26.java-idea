package stream;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author ywh
 * @date 2019/10/15 20:05
 * @description   Collection和Stream结合
 */
public class StreamTest {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        Collections.addAll(list, "a", "s", "d");
        //使用forEach输出
        list.forEach(System.out::println);
        //Collection接口中的重要方法stream
        Stream<String> stream = list.stream();
        System.out.println(stream.count());
    }
}
