package Eight_15;

import java.util.Comparator;

/**
 * @author ywh
 * @date 2019/9/2 19:47
 * @description 实现comparable接口来进行比较
 */
public class Person implements Comparable<Person> {
   public int age;
   int name;

    @Override
    public int compareTo(Person o) {
        if (this.age < o.age) {
            return -1;
        } else if (this.age > o.age) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return String.format("{age=%d，name=%d}",age,name);
    }
}
