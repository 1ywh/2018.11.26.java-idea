package mianshi;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author ywh
 * @date 2020/3/28 19:51
 * @description 奇安信笔试
 */
public class test5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s=sc.nextLine();
        String[] a=s.split(",");
        int [] arr=new int[a.length];
        for(int i=0;i<a.length;i++){
          arr[i]=Integer.parseInt(a[i]);
        }
        int a1=0,a2=0,a3=0;
        if(arr.length==9){
            for(int i = 0; i < 4; i++){
               a1+=arr[i];
            }
            for(int i = 3; i < 7; i++){
                a2+=arr[i];
            }
            a3=arr[0];
            for(int i = 6; i < 9; i++){
                a3+=arr[i];
            }
            if(a1==a2&&a2==a3){
                System.out.println("yes");
            }else {
                System.out.println("no");
            }
        }
    }
}
