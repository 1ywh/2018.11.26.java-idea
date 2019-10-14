package enuminstance;

/**
 * 枚举接口
 * Author:ywh
 * Date:2019/02/09
 */
interface IColor {
    String getColor();
}

enum Color2 implements IColor {
    RED("红"),
    BLUE("蓝");
    private String title;

    private Color2(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return super.toString() + title;
    }

    @Override
    public String getColor() {
        return title;
    }
}

public class IEnum {
    public static void main(String[] args) {
        Color2 col = Color2.BLUE;
        //默认调用toString
        System.out.println(col);
        System.out.println(col.getColor());
    }
}
