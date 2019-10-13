package enuminstance;

/**枚举返回序数、名字、数组
 * Author:ywh
 * Date:2019/02/09
 */

enum Color1 {
    BLUE, ODE, BLACK;
}

public class EnumTest {

    public static void main(String[] args) {

        //ordinal()返回序号，name()返回具体内容
        // 1.System.out.println(Color1.ODE.ordinal()+"="+Color1.ODE.name());

        //2.Color1.values()返回一个数组
        for (Color1 temp : Color1.values()) {
            System.out.println(temp.ordinal() + "=" + temp.name());
        }

        //3.返回带指定名称的指定枚举类型的枚举常量
        Color1 col=Color1.valueOf("ODE");
        System.out.println(col);

        //4.
        System.out.println(col.toString());
    }


}
