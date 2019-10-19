package TestSummary3;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ywh
 * @date 2019/10/19 16:50
 * @description
 */
public class test1 {
    public static void main(String[] args) {
        System.out.println(1.1 * 1.1);
        int num = 9;
        char num1 = '9';
        System.out.println((int) num1);//57
        System.out.println(num + num1);//66
        long num2 = Integer.MAX_VALUE + 1l;
        System.out.println(num2);//2147483648
        double a = 14.0 % 3.0;
        double b = -14.0 % 3.0;
        double c = -14.0 % -3.0;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        Integer a1 = 127;
        Integer a2 = 127;
        Integer a3 = new Integer(127);
        Integer a4 = new Integer(127);
        Integer a5 = a4;
        System.out.println(a1 == a1);
        System.out.println(a3 == a4);
        System.out.println(a2 == a3);
        System.out.println(a5 == a2);
        System.out.println(a4 == a5);
        String b1 = new String("abc");
        String s = "java" + "A" + 2020;
        System.out.println(s);
        boolean aa = a5 == a4;
        System.out.println(a5.equals(aa));
//        Scanner scanner = new Scanner(System.in);
//        String ac = scanner.nextLine();
//        char cc=ac.charAt(0);
//        System.out.println(cc);
//        int s1=Integer.parseInt(ac);
//        Double s2=Double.parseDouble(ac);
//        System.out.println(s1+","+s2);
        int [][] aaa=new int[][]{{1,2},{3,4}};
        for(int[] q1:aaa){
            for(int q2:q1){
                System.out.print(q2);
            }
        }
        int[] dataA = new int[]{1,2,3,4} ;
        int[] dataB = new int[]{11,22,33} ;
        System.arraycopy(dataB,0,dataA,2,2) ;//11 22 1 2 3 4
        System.out.println("System.arraycopy方法"+Arrays.toString(dataA));
        int[] result1 = Arrays.copyOfRange(dataA,0,2);
        System.out.println(Arrays.toString(result1));
        int[][] l=new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        int[][] ll=new int[3][3];
        for(int i=0;i<l.length;i++){
            ll[i]=l[i].clone();
        }
        int[][] lll=l.clone();

        //改变c[0][0]的值a[0][0]的值也改变
        lll[0][0]=2;
        System.out.println(Arrays.deepToString(l));
        System.out.println(Arrays.deepToString(ll));
        System.out.println(Arrays.deepToString(lll));

    }
}
