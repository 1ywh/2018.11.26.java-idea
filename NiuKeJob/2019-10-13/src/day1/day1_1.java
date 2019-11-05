package day1;

import java.util.Scanner;

/**
 * @author ywh
 * @date 2019/11/5 19:27
 * @description   插入字符串、判断回文
 */
public class day1_1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] a = new String[2];
        for (int i = 0; i < 2; i++) {
            a[i] = scan.nextLine();
        }
        String a1 = a[0];
        String b1 = a[1];
        int count = 0;
        for (int i = 0; i < a1.length() + 1; i++) {
            StringBuffer stringBuffer = new StringBuffer(a1);
            stringBuffer.insert(i, b1);
            System.out.println(stringBuffer);
            if (count(stringBuffer.toString())) {
                count++;
            }
        }
        System.out.println(count);
    }
    private static boolean count(String bb) {
        int j = bb.length() - 1;
        for (int i = 0; i < bb.length() / 2; i++, j--) {
            if (!(bb.charAt(i) == bb.charAt(j))) {
                return false;
            }
        }
        return true;
    }
}
