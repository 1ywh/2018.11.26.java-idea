package suan_fa;

/**
 * @author ywh
 * @date 2019/11/12 22:33
 * @description
 */
public class BuyBottle {
    public static int test(int n) {

        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        int a = n / 3;
        int b = n % 3;
        return a + test(a + b);

    }

    public static void main(String[] args) {
        System.out.println(test(81));
    }
}