package org.breeze.base.DesignPattern.StatePattern.MarioExample;

public class CapeMario implements IMario {
    private static final CapeMario instance = new CapeMario();

    private CapeMario(){}

    public static CapeMario getInstance(){
        return instance;
    }

    @Override
    public State getName() {
        return State.CAPE;
    }

    @Override
    public void obtainMushRoom(MarioStateMachine marioStateMachine) {
        //小马里奥 变身 超级 马里奥
        marioStateMachine.setCurrentState(CapeMario.getInstance());
        //体型 + 100
        marioStateMachine.setScore(marioStateMachine.getScore()+100);
    }

    @Override
    public void obtainCape(MarioStateMachine marioStateMachine) {
        marioStateMachine.setCurrentState(CapeMario.getInstance());
        //体型 + 200
        marioStateMachine.setScore(marioStateMachine.getScore()+200);
    }

    @Override
    public void obtainFireFlower(MarioStateMachine marioStateMachine) {
        marioStateMachine.setCurrentState(FireMario.getInstance());
        //体型 + 300
        marioStateMachine.setScore(marioStateMachine.getScore()+300);
    }

    @Override
    public void meetMonster(MarioStateMachine marioStateMachine) {
        marioStateMachine.setCurrentState(SuperMario.getInstance());
        //体型 - 200
        marioStateMachine.setScore(marioStateMachine.getScore()-200);
    }
}
