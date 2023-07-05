package org.breeze.DesignPattern.ObserverPattern.CusObserverPattern;


public class Test {

    public static void main(String[] args) {
        //明星人物，韩非子
        BizService hanFeiZi = new BizService();

        //偷窥狂，李斯
        BizServiceListener liSi = new BizServiceListener();

        //既然是 明星人物，自然会有很多偷窥狂，这里可以自行添加

        //李斯要监控 韩非子
        hanFeiZi.addObserver(liSi);

    }

}
