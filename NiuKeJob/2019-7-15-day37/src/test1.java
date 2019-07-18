import java.util.Scanner;

/**
 * 已知n阶矩阵，求矩阵元素之和，第一行为阶数
 * Author:ywh
 * Date:2019/07/15
 */
public class test1 {
    public static void main(String[] args) {
        int x=0;
        Scanner scan=new Scanner(System.in);
        //该n就是矩阵的阶数
       int n=scan.nextInt();
       for(int i=0;i<n;i++){
           for(int j=0;j<n;j++){
               int c=scan.nextInt();
               //这里输出的c是n以后的
               System.out.println(c);
               x=c+x;
           }
       }

        System.out.println(x);
    }
}
