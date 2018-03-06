package designParttens.sigleton.factory;

/**
 * Created by LZP on 2017/11/23.
 */
public class YellowMan implements Human {
    private String color;

    public String getColor() {
        return color;
    }

    public void talk() {
        System.out.println("我是黄种人  哈哈哈哈");
    }
}
