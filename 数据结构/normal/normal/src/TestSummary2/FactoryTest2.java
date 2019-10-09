package TestSummary2;

import java.util.Scanner;

/**
 * @author ywh
 * @date 2019/10/9 20:23
 * @description  简单工厂模式
 */
interface IM1 {
    void computer();
}

class compute3 implements IM1 {

    @Override
    public void computer() {
        System.out.println("第1个");
    }
}

class computers implements IM1 {

    @Override
    public void computer() {
        System.out.println("第2个");
    }
}

class Factory {
    static IM1 getInstance(String m) {
        IM1 im = null;
        if (m.equals("1")) {
            im = new compute3();
        } else if (m.equals("2")) {
            im = new computers();
        }
        return im;
    }
}

public class FactoryTest2 {
    public void print(IM1 im) {
        im.computer();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        FactoryTest2 factoryTest2 = new FactoryTest2();

        IM1 im = Factory.getInstance(answer);
        factoryTest2.print(im);
    }
}
