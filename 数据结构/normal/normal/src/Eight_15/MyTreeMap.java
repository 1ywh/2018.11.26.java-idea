package Eight_15;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author ywh
 * @date 2019/9/11 18:44
 * @description
 * TreeMap 中key 类型必须是comparable 或者是构造是传入comparator
 * TreeSet  Element中类型必须是comparable 或者是构造是传入comparator
 * 搜索树是中序有序性， 用到该特点的时候考虑TreeSet/TreeMap
 */

//1.实现Comparable，覆写 compareTo
class Person1  implements Comparable<Person1> {
    String name;

    public Person1(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Person1 o) {
        return name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return "Person1{" +
                "name='" + name + '\'' +
                '}';
    }
}
//2.实现 Comparator，覆写compare
class PersonComparator implements Comparator<Person1> {

    @Override
    public int compare(Person1 o1, Person1 o2) {
        return o1.name.compareTo(o2.name);
    }
}

class Contact {
    private String name;
    private String address;

    public Contact(String name, String address) {
        this.address = address;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
//3.具体实现
public class MyTreeMap {
    public static void main(String[] args) {
        Contact contact = new Contact("oo", "dd");
        Person1 person1 = new Person1("pp");
        // 因为String类本身是有comparable接口的可以使用
        // 但是以下的key是Person类型，没有那个接口

        //一、TreeMap的实现
        // 方法1：实现Comparator接口，最后传入一个Comparator比较器
        //TreeMap<Person1, Contact> treeMap = new TreeMap<>(new PersonComparator());

        //方法2：实现Comparable<Person>接口，直接使用
        TreeMap<Person1, Contact> treeMap = new TreeMap<>();
        treeMap.put(person1, contact);
        for (Map.Entry<Person1, Contact> entry : treeMap.entrySet()) {
            Person1 number = entry.getKey();
            Contact cnt = entry.getValue();
            System.out.println(number+"  "+cnt);
        }
        //TreeSet的实现，不能使用Contact类，会CCE，因为它没有实现comparable或者Comparator
        TreeSet<Person1> treeSet = new TreeSet<>();
        treeSet.add(person1);
        System.out.println(treeSet);
    }
}
