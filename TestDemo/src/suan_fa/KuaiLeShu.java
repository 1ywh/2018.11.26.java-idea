package suan_fa;

/**
 * @author ywh
 * @date 2019/11/12 22:16
 * @description
 * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，
 *  然后重复这个过程直 到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
 *
 */
public class KuaiLeShu {
    public static int getNext(int num) {
        int result = 0;
        result = result + (num % 10) * (num % 10);
        num = num / 10;
        if (num == 0) {
            return result;
        } else {
            return result + getNext(num);
        }
    }

    public static boolean isHappy(int num) {
//        Set<Integer> set = new HashSet<>();
//        while (num != 1) {
//             num = getNext(num);
//             if(!set.contains(num)){
//                 set.add(num);
//             }else{
//                 return false;
//             }
//        }
//        return true;

        while (true) {
            num = getNext(num);
            if (num == 1) {
                return true;
            } else {
                if (num == 89) {
                    return false;
                }

            }
        }

    }

    public static void main(String[] args) {
        System.out.println(isHappy(20));
        System.out.println();
    }
}
