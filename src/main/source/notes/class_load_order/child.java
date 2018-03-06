package notes.class_load_order;

/**
 * Created by LZP on 2017/11/29.
 */
public class child extends parents {
    public static int age = 20;
    static {
        System.out.println(age);
    }
    static {
        System.out.println("子类静态代码块");
    }

    child(){
        System.out.println("子类构造函数");
    }
    public static void method1(){
        System.out.println("子类静态方法");
    }

    public static void main(String[] args) {
       /* child peo =new child();
        child.method1();*/

       parents peo1 = new child();
       parents.method1();
    }
}
