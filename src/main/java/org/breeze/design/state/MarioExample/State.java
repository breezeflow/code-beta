package org.breeze.design.state.MarioExample;

/**
 * 状态枚举
 */
public enum State {


    SMALL(0),
    SUPER(1),
    FIRE(2),
    CAPE(3);

    State(int value) {
        this.value = value;
    }

    private int value;

    public int getValue() {
        return this.value;
    }

}
