package org.breeze.design.StatePattern.MarioExample;

/**
 * 超级玛丽
 */
public class SuperMario implements IMario {

    private static final SuperMario instance = new SuperMario();

    private SuperMario(){}

    public static SuperMario getInstance(){
        return instance;
    }

    @Override
    public State getName() {
        return State.SUPER;
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
        marioStateMachine.setCurrentState(SuperMario.getInstance());
        //体型 + 200
        marioStateMachine.setScore(marioStateMachine.getScore()+200);
    }

    @Override
    public void obtainFireFlower(MarioStateMachine marioStateMachine) {
        marioStateMachine.setCurrentState(SuperMario.getInstance());
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
