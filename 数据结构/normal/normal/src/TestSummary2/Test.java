package TestSummary2;

/**
 * @author ywh
 * @date 2019/10/11 19:20
 * @description
 */
//成员内部类,非静态内部类
public class Test {
    public static void main(String[] args) {
        Outer outer = new Outer();
        System.out.println(outer.age());//18
        System.out.println(outer.name());//liu
        System.out.println(new B11().getName());//liu

        //非静态和静态内部类在其他地方使用的时候创建对象的方式
        //外部类.内部类
        //创建了一个外部类的引用
        Outer.InnerA innerA = outer.new InnerA();
        System.out.println(innerA.name());//liu
        outer.display();
    }
}

//普通类A
class A11 {
    private String name = "liu";

    public String getName() {
        return this.name;
    }
}

//B继承A
class B11 extends A11 {
    private int age = 18;

    public int getAge() {
        return this.age;
    }

    public String getName() {
        return super.getName();
    }
}

//外部类Outer
class Outer {
    private int num = 20;

    //成员内部类InnerA，非静态内部类并且继承了A
    class InnerA extends A11 {
        public String name() {
            return super.getName();//父类
        }
    }

    class InnerB extends B11 {
        public int age() {
            return super.getAge();
        }
    }

    //外部类访问内部类的方法或者属性必须创建内部类实例化的对象
    public int age() {
        return new InnerB().age();
    }

    public String name() {
        return new InnerA().name();
    }

    //方法内部类
    public void display() {
        class Inner {
            public void fun() {
                num++;
                System.out.println(num);
            }
        }
        new Inner().fun();
    }

}



