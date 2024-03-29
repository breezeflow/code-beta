package org.breeze.design.state.MarioExample;

public class FireMario implements IMario {
    private static final FireMario instance = new FireMario();

    private FireMario(){}

    public static FireMario getInstance(){
        return instance;
    }

    @Override
    public State getName() {
        return State.FIRE;
    }

    @Override
    public void obtainMushRoom(MarioStateMachine marioStateMachine) {
        //小马里奥 变身 超级 马里奥
        marioStateMachine.setCurrentState(FireMario.getInstance());
        //体型 + 100
        marioStateMachine.setScore(marioStateMachine.getScore()+100);
    }

    @Override
    public void obtainCape(MarioStateMachine marioStateMachine) {
        marioStateMachine.setCurrentState(FireMario.getInstance());
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
        marioStateMachine.setCurrentState(FireMario.getInstance());
        //体型 - 200
        marioStateMachine.setScore(marioStateMachine.getScore()-200);
    }
}
