package designParttens.sigleton.sigleton;

/**
 * Created by LZP on 2017/11/23.
 */
public class Sigleton1 {
    private static Sigleton1 instance = new Sigleton1();//多线程情况下这句可能多次执行
    private Sigleton1(){}
    public Sigleton1 getInstance(){
        return instance;
    }
}
