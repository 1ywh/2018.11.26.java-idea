package TestSummary3;

/**
 * @author ywh
 * @date 2019/10/21 17:30
 * @description 包装类型
 */
public class TestBao {
    public static void main(String[] args) {
        Integer obj = new Integer(10);
        int in = obj.intValue();
        System.out.println(in);

        //JDK自动装箱、拆箱
        Object o = 10;
        int a = (int) o;
        System.out.println(a);

        Integer a1 = 100;
        Integer a2 = 100;
        Integer a3=128;
        Integer a4=128;

        Integer obj1 = new Integer(100);
        Integer obj2 = new Integer(100);
        //用到了Integer.valueOf()的缓存
        System.out.println(a1 == a2);//true 他们的值相等
        System.out.println(a3==a4);//false

        System.out.println(a1.equals(a2));//true
        System.out.println(a1 == obj1);//false
        System.out.println(a1.equals(obj1));//true

        System.out.println(obj1 == obj2);//false
        System.out.println(obj1.equals(obj2));//true

    }
}
