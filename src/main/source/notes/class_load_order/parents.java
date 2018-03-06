package notes.class_load_order;

/**
 * Created by LZP on 2017/11/29.
 */
public class parents {
    public static int age = 50;
    static {
        System.out.println(age);
    }
    static {
        System.out.println("父类静态代码块");
    }

    parents(){
        System.out.println("父类构造函数");
    }
    public static void method1(){
        System.out.println("父类静态方法");
    }

}
