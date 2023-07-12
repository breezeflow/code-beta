package org.breeze.design.StatePattern.MarioExample;

enum State{
    SMALL(0),
    SUPER(1),
    FIRE(2),
    CAPE(3);

    State(int value){
        this.value = value;
    }

    private int value;

    public int getValue(){
        return this.value;
    }

}

/**
 * 所有事件的接口
 */
public interface IMario {

    State getName();

    //定义的事件

    //吃蘑菇（有的版本好像是吃小盒子）
    void obtainMushRoom(MarioStateMachine marioStateMachine);

    //获得护甲（防护道具）
    void obtainCape(MarioStateMachine marioStateMachine);

    //稀有加成（太阳花之类的）
    void obtainFireFlower(MarioStateMachine marioStateMachine);

    // 踩到怪物
    void meetMonster(MarioStateMachine marioStateMachine);

}


