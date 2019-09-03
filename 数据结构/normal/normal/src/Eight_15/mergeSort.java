package Eight_15;

import java.util.Arrays;
import java.util.Random;

/**
 * @author ywh
 * @date 2019/9/2 18:44
 * @description  compareTo接口来进行比较，实现接口，覆写方法
 */
public class mergeSort {

    //简单的比较实现
    public static void s() {
        Person person1 = new Person();
        person1.age = 2;
        Person person2 = new Person();
        person1.age = 3;
        //加这个
        int a = person1.compareTo(person2);
        if (a > 0) {
            System.out.println("iii");
        } else {
            System.out.println(8);
        }
    }

    public static void merge(Person arr[], int left, int right, int mid) {
        //改为Person类型
        Person x[] = new Person[arr.length];
        int k = 0;
        int i = left;
        int j = mid;
        while (i < mid && j < right) {
            //加这个
            int p = arr[i].compareTo(arr[j]);
            if (p <= 0) {
                x[k++] = arr[i++];
            } else {
                x[k++] = arr[j++];
            }
        }
        while (i < mid) {
            x[k++] = arr[i++];
        }
        while (j < right) {
            x[k++] = arr[j++];
        }
        for (int u = 0; u < right - left; u++) {
            arr[u + left] = x[u];
        }
    }

    public static void mergeInner(Person arr[], int left, int right) {
        if (right - left <= 1) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeInner(arr, left, mid);
        mergeInner(arr, mid, right);
        merge(arr, left, right, mid);
    }

    public static void main(String[] args) {
        Person[] person = new Person[10];
        Random random = new Random(100);
        for (int i = 0; i < person.length; i++) {
            person[i] = new Person();
            person[i].age = random.nextInt(100);
            person[i].name = random.nextInt(20);
        }
        System.out.println(Arrays.toString(person));
        mergeInner(person, 0, person.length);
        System.out.println(Arrays.toString(person));
        s();
    }
}
