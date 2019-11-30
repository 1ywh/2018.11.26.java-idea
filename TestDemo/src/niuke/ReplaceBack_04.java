package niuke;

/**
 * @author ywh
 * @date 2019/11/29 21:38
 * @description   替换空格
 * 将一个字符串中的空格替换成 "%20"。
 */
public class ReplaceBack_04 {
    //    先计算替换后的字符串需要多大的空间，并对原字符串空间进行扩容；
    //    从后往前替换字符串的话，每个字符串只需要移动一次；
    //    如果从前往后，每个字符串需要多次移动，效率较低。
    public String re(StringBuffer str) {
        String str1 = str.toString();
        String a = str1.replaceAll(" ", "%20");
        return a;
    }

    public String replaceSpace(StringBuffer str) {
        int p1 = str.length() - 1;
        for (int i = 0; i <= p1; i++) {
            char a = str.charAt(i);
            if (a == ' ') {
                str.append("  ");
            }
        }
        int p2 = str.length() - 1;
        while (p1 >= 0 && p2 > p1) {
            char b = str.charAt(p1--);
            if (b == ' ') {
                str.setCharAt(p2--, '0');
                str.setCharAt(p2--, '2');
                str.setCharAt(p2--, '%');
            } else {
                str.setCharAt(p2--, b);
            }
        }
        return str.toString();
    }
}
