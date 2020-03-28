package mianshi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ywh
 * @date 2020/3/23 22:08
 * @description
 */
public class test1 {
    public static void test(int[] arr) {
        int sum = 0;
        for (int ss : arr) {
            sum += ss;
        }
        boolean tag = true;
        Arrays.sort(arr);
        while (tag) {
            if (sum % 3 == 0) {
                System.out.println(sum / 3);
                tag = false;
            } else if(sum%3<0){
                System.out.println(0);
                tag = false;
            }else {
                for (int i = 0; i < arr.length; i++) {
                    if ((sum - arr[i]) % 3 == 0) {
                        System.out.println((sum - arr[i])  / 3);
                        tag = false;
                        break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(",");
        int[] arr = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        test(arr);
    }
}
