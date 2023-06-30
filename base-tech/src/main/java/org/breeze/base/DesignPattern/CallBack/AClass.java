package org.breeze.base.DesignPattern.CallBack;

public class AClass {

    public static void main(String[] args) {

        System.out.println("this is A class , is calling  b class method ...  ");

        BClass b = new BClass();
        // A类调用B  并向B 注入（传递的意思）回调方法
        b.process(new ICallBack() {
            @Override
            public void methodToCallBack() {
                System.out.println("Call back me");
            }
        });

    }

}
