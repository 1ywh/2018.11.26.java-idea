package TestSummary;

/**
 * @author ywh
 * @date 2019/9/24 20:20
 * @description 内部类和外部类的使用，内部类可以访问外部类的私有属性,外部类中有个方法可以调用内部类完成功能
 */
class Outer{
    private  String name;
    //定义一个内部类
    class Inner{
        //内部类中的方法可以访问外部类的私有属性
        public void  fun(){
            System.out.println(name);
        }
    }
    //外部类中的方法负责产生内部类对象然后调用内部类的方法fun()
    public void print(){
        Inner inner=new Inner();
        inner.fun();
    }
}
public class InnerClass {
    public static void main(String[] args) {
        Outer outer=new Outer();
        outer.print();
    }

}
