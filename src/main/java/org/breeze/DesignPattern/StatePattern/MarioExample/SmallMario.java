package org.breeze.DesignPattern.StatePattern.MarioExample;

/**
 * 小玛丽
 */
public class SmallMario implements IMario {

    private static final SmallMario instance = new SmallMario();

    private SmallMario(){}

    public static SmallMario getInstance(){
        return instance;
    }

    @Override
    public State getName() {
        return State.SMALL;
    }

    @Override
    public void obtainMushRoom(MarioStateMachine marioStateMachine) {
        //小马里奥 变身 超级 马里奥
        marioStateMachine.setCurrentState(SuperMario.getInstance());
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
