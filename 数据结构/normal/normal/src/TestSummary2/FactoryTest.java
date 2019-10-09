package TestSummary2;

/**
 * @author ywh
 * @date 2019/10/9 20:14
 * @description 普通的实现
 */
interface IM {
    void computer();
}

class computer1 implements IM {

    @Override
    public void computer() {
        System.out.println("1");
    }
}

class computer2 implements IM {

    @Override
    public void computer() {
        System.out.println("2");
    }
}

public class FactoryTest {
    public void print(IM im) {
        im.computer();
    }
    public static void main(String[] args) {
        //   FactoryTest factoryTest=new FactoryTest();
        // factoryTest.print(new computer1());
        IM im = new computer1();
        im.computer();
    }
}
