package mianshi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author ywh
 * @date 2020/4/12 14:04
 * @description
 */
public class Main {
    //正方形
    public static double cFX(double x, double y) {
        return x * y;
    }

    //长方形
    public static double zFX(double x) {
        return x * x;
    }

    //圆
    public static double Y(double r) {
        return r * r * 3.14;
    }

    //三角形
    public static double sJX(double x, double y,double z) {
        double p=(x+y+z)/2;
        return Math.sqrt(p*(p-x)*(p-y)*(p-z));
    }

    public static void main(String[] args) {
        System.out.println(cFX(5.5, 3.8));
        System.out.println(zFX(12));
        System.out.println(Y(5.5));
        System.out.println(sJX(3.0,4.0,5.0));
    }
}
