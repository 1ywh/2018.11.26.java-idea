package enuminstance;

/**
 * Author:ywh
 * Date:2019/02/09
 * 枚举可以使用switch
 */
enum Sex {
    MALE, FEMALE;
}

public class Enum1 {
    public static void main(String[] args) {
        switch (Sex.MALE) {
            case MALE:
                System.out.println("男人");
                break;
            case FEMALE:
                System.out.println("女人");
                break;
        }
    }
}
