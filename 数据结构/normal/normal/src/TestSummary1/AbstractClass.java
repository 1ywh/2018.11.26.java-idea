package TestSummary1;

/**
 * @author ywh
 * @date 2019/9/26 17:57
 * @description   对象实例化
 * 1.进行类加载
 * 2.进行类对象的空间开辟
 * 3.进行类对象中的属性初始化(构造方法)
 */
abstract class Person {
    //3.调用父类构造
    public Person() {
    //4.调用被子类覆写的方法
        this.getPersonInfo();
    }
    public abstract void getPersonInfo();
}
class Student extends Person {
    private int num = 100;

    public Student(int num) {
        super(); //2.也可以隐藏，不写的话也是先看父类的构造方法
        this.num = num; //7.为类中属性初始化
    }
    @Override
    public void getPersonInfo() {
        //5.此时子类对象的属性还没有被初始化
        //6.对应其数据类型的默认值
        System.out.println(this.num);
    }
}
public class AbstractClass {
    public static void main(String[] args) {
        //1.实例化子类
        new Student(30).getPersonInfo();//0 30
        new Student(30);//0
    }
}
