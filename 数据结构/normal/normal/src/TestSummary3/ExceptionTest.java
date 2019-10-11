package TestSummary3;
import java.util.Scanner;
/**
 * @author ywh
 * @date 2019/10/11 21:36
 * @description   Alt+enter
 */
public class ExceptionTest {
    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        try {
            System.out.println("begin");
            a = null;
            System.out.println(a[100]);
            System.out.println("end");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("ending");
        }
        try (Scanner scan = new Scanner(System.in)) {
            int a1 = scan.nextInt();
            System.out.println(a1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
