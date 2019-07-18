import java.util.ArrayList;
import java.util.Scanner;


/**
 *经过木棒的移动能否构成多边形
 * Author:ywh
 * Date:2019/07/15
 */
public class test2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int n = scan.nextInt();
            //定义一个二维数组
            int[][] d = new int[n][2];
            for (int i = 0; i < n; i++) {
                d[i][0] = scan.nextInt();
                d[i][1] = scan.nextInt();
            }
            isQ(n, d);
        }
    }

    public static void isQ(int n, int[][] d) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (d[i][0] == 1) {
                list.add(d[i][1]);
            } else {
                list.remove(d[i][1]);
            }
            if(is(list)){
                System.out.println("yes");
            }else{
                System.out.println("no");
            }
        }
    }

    public static boolean is(ArrayList<Integer> list) {
        int n = list.size();
        for (int i = 0; i < n; i++) {
            //多边形的话，最大边小于剩余边之和
            int sum = 0;
            int t = list.remove(i);
            for (int j = 0; j < n - 1; j++) {
                sum += list.get(j);
            }
            if (sum <= t) {
                list.add(i,t);
                return false;
            }
            list.add(i,t);
        }
        return true;
    }
}

