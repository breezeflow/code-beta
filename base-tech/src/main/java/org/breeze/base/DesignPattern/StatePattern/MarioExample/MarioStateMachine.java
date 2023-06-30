package org.breeze.base.DesignPattern.StatePattern.MarioExample;

import lombok.Data;

/**
 * 马里奥 状态机
 */
@Data
public class MarioStateMachine {

    private int score;

    private IMario currentState;

    public MarioStateMachine() {
        this.score = 0;
        this.currentState = SmallMario.getInstance();
    }

    public void obtainMushRoom() {
        this.currentState.obtainMushRoom(this);
    }

    public void obtainCape() {
        this.currentState.obtainCape(this);
    }

    public void obtainFireFlower() {
        this.currentState.obtainFireFlower(this);
    }

    public void meetMonster() {
        this.currentState.meetMonster(this);
    }
}
