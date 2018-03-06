package designParttens.sigleton.factory;

/**
 * Created by LZP on 2017/11/23.
 */
public class HumanFactory extends AbstractHumanFactory {
    public <T extends Human> T creatHuman(Class<T> tClass) {
        Human human = null;
        try{
            human = (T)Class.forName(tClass.getName()).newInstance();
            System.out.println("成功生产。。。");
        }catch (Exception e){
            System.out.println("失败。。。。");
            e.printStackTrace();
        }
        return (T)human;
    }
}
