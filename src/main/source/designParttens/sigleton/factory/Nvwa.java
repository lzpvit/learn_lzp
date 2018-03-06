package designParttens.sigleton.factory;

/**
 * Created by LZP on 2017/11/23.
 */
public class Nvwa {
    public static void main(String[] args) {
        AbstractHumanFactory abstractHumanFactory =new HumanFactory();
        Human black =abstractHumanFactory.creatHuman(BlackMan.class);
        black.talk();

        Human yellow =abstractHumanFactory.creatHuman(YellowMan.class);
        yellow.getColor();
        yellow.talk();
    }
}
