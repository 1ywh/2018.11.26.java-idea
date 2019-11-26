package suan_fa;

/**
 * @author ywh
 * @date 2019/11/12 22:49
 * @description
 */
public class Fibonacci {
    public static void main(String[] args) {

        System.out.println(T1(5));
        System.out.println(T(5));
    }
    public static int T(int n) {
        int f=0;
        if (n <= 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        for (int i = 3; i <=n; i++) {
            f= T(n- 1) + T(n - 2);
        }
        return f;
    }
    public static int T1(int n){
        int a=0;
        int b=1;
        int c=0;
        if(n<=0){
            return 0;
        }
        for(int i=3;i<=n;i++){
            c=a+b;
            a=b;
            b=c;
        }
        return c;
    }
}
