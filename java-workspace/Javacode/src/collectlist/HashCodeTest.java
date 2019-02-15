package collectlist;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.Stack;

/**重复元素的判断
 * 覆写hashCode()与equals()方法消除重复
 * Author:ywh
 * Date:2019/02/15
 */

class Person implements Comparable<Person> {

    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Person o) {
        if (this.age > o.age) {
            return 1;
        } else if (this.age < o.age) {
            return -1;
        } else {
            return this.name.compareTo(o.name);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Person person = (Person) obj;
        return Objects.equals(name, person.name) &&
                Objects.equals(age, person.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}

public class HashCodeTest {
    public static void main(String[] args) {
        Set<Person> set = new HashSet<>();
        set.add(new Person("张三", 2));
        set.add(new Person("张三", 2));
        set.add(new Person("李四", 6));
        System.out.println(set);
    }
}
