package lambda;

/**
 * lambda表达式
 * (参数) ->单行语句
 * Author:ywh
 * Date:2019/02/10
 */
@FunctionalInterface
//是一个函数式编程接口，只允许有一个方法
interface M {
    public void print();
}

public class Lambda1 {
    public static void main(String[] args) {
        //匿名内部例类，编写完整的语法
        M m = new M() {
            @Override
            public void print() {
                System.out.println("hello");
            }
        };
        m.print();

//       //lambda表达式，一个语句
//       M m=()-> System.out.println("hello");
//       m.print();
    }
}
