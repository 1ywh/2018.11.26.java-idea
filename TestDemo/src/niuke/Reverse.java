package niuke;

/**
 * @author ywh
 * @date 2020/1/22 15:29
 * @description  反转字符串
 */
public class Reverse {
    public static String ReverseSentence(String str) {
        String[] s=str.split(" ");
        StringBuilder str1=new StringBuilder();
        for(int i=s.length-1;i>=0;i--){
            str1.append(s[i]).append(" ");
        }
        return str1.toString();
    }
    public static void main(String[] args) {
        System.out.println(ReverseSentence("aw. ou rr io"));
    }
}
