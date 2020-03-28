package mianshi;

import java.util.Scanner;

/**
 * @author ywh
 * @date 2020/3/28 19:39
 * @description  奇安信笔试
 */
public class test4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int b = in.nextInt();
        if (b <= 0) {
            System.out.println(0);
        } else if (b <= 2) {
            System.out.println(5);
        } else if (b <= 4) {
            System.out.println(8);
        } else if (b <= 6) {
            System.out.println(11);
        } else if (b <= 9) {
            System.out.println(13);
        } else if (b <= 11) {
            System.out.println(15);
        } else if (b <= 14) {
            System.out.println(17);
        } else {
            System.out.println(18);
        }

    }
}
