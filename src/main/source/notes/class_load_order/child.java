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
        System.out.println("���ྲ̬�����");
    }

    child(){
        System.out.println("���๹�캯��");
    }
    public static void method1(){
        System.out.println("���ྲ̬����");
    }

    public static void main(String[] args) {
       /* child peo =new child();
        child.method1();*/

       parents peo1 = new child();
       parents.method1();
    }
}
