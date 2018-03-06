package designParttens.sigleton.factory;

/**
 * Created by LZP on 2017/11/23.
 */
public class BlackMan implements Human {
    private String color;
    BlackMan(){
       this.color = "black";
    }
    public String getColor() {
        return color;
    }

    public void talk() {
        System.out.println("ÎÒÊÇºÚÈË ¹ş¹ş¹ş");
    }
}
