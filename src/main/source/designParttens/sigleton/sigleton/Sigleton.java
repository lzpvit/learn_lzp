package designParttens.sigleton.sigleton;

/**
 * Created by LZP on 2017/11/23.
 * ����ʽ����ģʽ
 */
public class Sigleton {
    private static Sigleton instance= null;
    private Sigleton(){}
    public Sigleton getSigleton(){
        synchronized (instance){
            if(instance==null){
                instance = new Sigleton();
            }
        }
        return instance;
    }
}
