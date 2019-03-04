package com.bittech;

/**反射实例化对象
 * Author:ywh
 * Date:2019/03/04
 */
interface IFruit {
    void eat();
}

class Apple implements IFruit {


    @Override
    public void eat() {
        System.out.println("eat apple");
    }
}

class Orange implements IFruit {

    @Override
    public void eat() {
        System.out.println("eat orange");
    }
}

class FruitFactory {
    private FruitFactory() {
    }

    public static IFruit getInstance(String className) {
        IFruit fruit = null;
        try {
            fruit = (IFruit) Class.forName(className).newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return fruit;
    }


}

public class Fruit {
    public static void main(String[] args) {
        IFruit fruit = FruitFactory.getInstance("com.bittech.Orange");
        fruit.eat();
    }
}
