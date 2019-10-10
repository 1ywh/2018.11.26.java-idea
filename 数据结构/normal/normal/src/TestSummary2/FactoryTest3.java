package TestSummary2;

/**
 * @author ywh
 * @date 2019/10/9 20:53
 * @description 工厂方法模式,创造工厂接口，其子类来决定使用那个实例对象
 */
interface Computer {
    void com();
}
class comm1 implements Computer {
    @Override
    public void com() {
        System.out.println("1");
    }
}

class comm2 implements Computer {

    @Override
    public void com() {
        System.out.println("2");
    }
}

//由工厂来决定实例化的子类
interface ComputerFactory {
    Computer get();
}

class com1Factory implements ComputerFactory {

    @Override
    public Computer get() {
        return new comm1();
    }
}

class com2Factory implements ComputerFactory {

    @Override
    public Computer get() {

        return new comm2();
    }
}

public class FactoryTest3 {
    public void print(Computer computer) {
        computer.com();
    }

    public static void main(String[] args) {
        FactoryTest3 factoryTest3 = new FactoryTest3();
        ComputerFactory factory=new com1Factory();
        factoryTest3.print(factory.get());
    }
}
