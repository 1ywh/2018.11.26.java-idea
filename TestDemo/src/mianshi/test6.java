package mianshi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ywh
 * @date 2020/3/29 19:30
 * @description  baidu
 */
public class test6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        int k=0;
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        Arrays.sort(arr);
        int max = Integer.MAX_VALUE;
        if(n<=50&&n>=2){
            while (max>=n) {
                if(k==0){
                    max=arr[n-1];
                }
                arr[n-1]=max-n;
                for(int i=0;i<n-1;i++){
                    arr[i]=arr[i]+1;
                }
                Arrays.sort(arr);
                max=arr[n-1];
                k+=1;
            }
        }
        System.out.println(k);
    }
}
