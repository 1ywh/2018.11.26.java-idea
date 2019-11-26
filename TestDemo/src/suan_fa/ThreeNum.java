package suan_fa;

/**
 * @author ywh
 * @date 2019/11/12 22:21
 * @description 首次出现三次的英文字母
 */
public class ThreeNum {
    public static void main(String[] args) {
        String a = "have you  ever gone shoping";
        System.out.println(find(a));
    }

    private static char find(String a) {
        char[] aa = a.toCharArray();
        int[] hash = new int[256];
        for (int i = 0; i < aa.length; i++) {
            char c = aa[i];
            if ((c <= 'Z' && c >= 'A') || (c <= 'z' && c >= 'a')) {
                hash[c]++;
                if (hash[c] == 3) {
                    return c;
                }
            }
        }
        return 0;
    }
}
