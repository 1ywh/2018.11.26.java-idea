package enuminstance;

/**
 * Author:ywh
 * Date:2019/02/09
 */
enum Color {
    RAD("红色"), BLUE("蓝色");

    private String title;

    //方法私有
    private Color(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return this.title;
    }
}

public class Enum2 {
    public static void main(String[] args) {
        System.out.println(Color.BLUE);//蓝色
    }
}
