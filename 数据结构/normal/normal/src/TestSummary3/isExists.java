package TestSummary3;

/**
 * @author ywh
 * @date 2019/10/19 16:37
 * @description 是否存在i-1>i，i+1<i的数
 */
public class isExists {
    public static void main(String[] args) {
        int a=Integer.MAX_VALUE;
        int b=Integer.MIN_VALUE;
        if(a+1<a){
            System.out.println("存在i+1<i的数");
        }if(b-1>b){
            System.out.println("存在i-1>i的数");
        }
    }
}
