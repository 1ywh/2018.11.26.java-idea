package TestSummary2;

/**
 * @author ywh
 * @date 2019/10/9 21:26
 * @description  抽象工厂模式
 * 有多个抽象产品类，生成了具体的一组产品
 */

interface Computer1{
    void computer();
}

class c1 implements Computer1 {

    @Override
    public void computer() {
        System.out.println("c1");
    }
}

class c2 implements Computer1 {

    @Override
    public void computer() {
        System.out.println("c2");
    }
}

interface CFactory {
    void factory();
}

class f1 implements CFactory {
    @Override
    public void factory() {
        System.out.println("f1");
    }
}

class f2 implements CFactory {
    @Override
    public void factory() {
        System.out.println("f2");
    }
}

interface all {
    CFactory c();

    Computer1 cc();
}

class all1 implements all {

    @Override
    public CFactory c() {
        return new f1();
    }

    @Override
    public Computer1 cc() {
        return new c1();
    }
}

class all2 implements all {

    @Override
    public CFactory c() {
        return new f2();
    }

    @Override
    public Computer1 cc() {
        return new c2();
    }
}

public class FactoryTest4 {
    public void test1(Computer1 computer1) {
        computer1.computer();
    }

    public void test2(CFactory cFactory) {
        cFactory.factory();
    }

    public static void main(String[] args) {
        FactoryTest4 factoryTest4 = new FactoryTest4();
        all all1 = new all1();
        Computer1 computer1=all1.cc();
        CFactory cFactory=all1.c();
        factoryTest4.test1(computer1);
        factoryTest4.test2(cFactory);
    }
}
