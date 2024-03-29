package org.breeze.design.factory.SimpleFactory;


import org.breeze.design.factory.BlackHuman;
import org.breeze.design.factory.Human;
import org.breeze.design.factory.WhiteHuman;
import org.breeze.design.factory.YellowHuman;

/**
 * 工厂方法使用者：女娲，
 * 工厂：炼丹炉
 * 丹药：人类
 * 丹药类型：不同人类
 */
public class NvWa {
    public static void main(String[] args) {
        Human yellowHuman = HumanFactory.createHuman(YellowHuman.class);
        yellowHuman.cry();
        yellowHuman.laugh();
        yellowHuman.talk();

        Human whiteHuman = HumanFactory.createHuman(WhiteHuman.class);
        whiteHuman.cry();
        whiteHuman.laugh();
        whiteHuman.talk();

        Human blackHuman = HumanFactory.createHuman(BlackHuman.class);
        blackHuman.cry();
        blackHuman.laugh();
        blackHuman.talk();

        for(int i=0;i<5;i++){
            System.out.println("-------------随机产生人类-------------------");
            Human human = HumanFactory.createHuman();
            human.cry();
            human.laugh();
            human.talk();
        }
    }
}
