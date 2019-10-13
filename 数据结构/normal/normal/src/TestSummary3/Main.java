package TestSummary3;

import java.util.*;

/**
 * @author ywh
 * @date 2019/10/12 19:23
 * @description  最小步数找到fibonacci数
 */
public class Main {
    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);

    }

    public static void count(int n) {
        int num = 0;
        int x = 0;
        while (num >= 0) {
            if (fibonacci(num) >= n) {
                //找到第一个大于它的
                x = fibonacci(num);
                break;
            } else {
                num++;
            }
        }
        //找到小于它的
        int y = fibonacci(num - 1);
        System.out.println(Math.min(x - n, n - y));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        count(a);
    }
}