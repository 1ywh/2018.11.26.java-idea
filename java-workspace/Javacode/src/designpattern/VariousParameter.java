package designpattern;

/**
 * Author:ywh
 * Date:2019/02/09
 * 如果要传递多类参数，可变参数一定放在最后，并且只能设置一个可变参数
 */
public class VariousParameter {
    public static void main(String[] args){
        System.out.println(add("Hello"));
        System.out.println(add("w",new int[]{1,2,3}));
        System.out.println(add("ee",12,3));
    }
    public static int add(String a, int... data) {
        int result=0;
        for (int i=0;i<data.length;i++) {
   result+=data[i];
        }
        return result;
    }

}
