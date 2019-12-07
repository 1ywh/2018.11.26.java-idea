package niuke;

/**
 * @author ywh
 * @date 2019/12/6 20:02
 * @description   调整数组顺序
 */
public class reOrderArray {
    public void reOrderArray1(int[] array) {
        if (array.length == 0) {
            return;
        }
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] % 2 == 0 && array[j + 1] % 2 != 0) {
                    int a = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = a;
                }
            }
        }
    }
}