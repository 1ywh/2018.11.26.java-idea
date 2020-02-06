package leetcode;

/**
 * @author ywh
 * @date 2020/2/6 14:17
 * @description  大写字母--->小写字母
 */
public class LowCase {
    public String toLowerCase(String str) {
        if(str.length()==0){
            return  null;
        }
        String result="";
        for(int i=0;i<str.length();i++){
            char a=str.charAt(i);
            if(a<=90&&a>=65){
                a+=32;
            }
            result+=a;
        }
        return result;
        //return str.toLowerCase();
    }
}
