package designParttens.sigleton.factory;

/**
 * Created by LZP on 2017/11/23.
 */
public abstract class AbstractHumanFactory {
    public abstract <T extends Human>T creatHuman(Class<T> tClass);
}
