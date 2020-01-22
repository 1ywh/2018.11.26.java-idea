package niuke;

/**
 * @author ywh
 * @date 2020/1/22 15:10
 * @description  左旋转字符串
 */
public class SubString {
    public static String LeftRotateString(String str, int n) {
        StringBuilder str1 = new StringBuilder();
        String a = str.substring(n);
        str1.append(a);
        for (int i = 0; i < n; i++) {
            str1.append(str.charAt(i));
        }
        return str1.toString();
    }

    public static void main(String[] args) {
        System.out.println(LeftRotateString("qwertyu",3));
    }
}
