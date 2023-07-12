package org.breeze.design.CallBack;

public class BClass {

    public void process(ICallBack callBack){

        // 其他类 调用 b 的process 方法

        // do somethings .....

        System.out.println("this is  B class , do something ..........");

        try {
            Thread.currentThread().sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //finish

        System.out.println(" i  have a  result , need return back to paren method ....");

        try {
            Thread.currentThread().sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // b调用 其他类注入的 回调方法

        //此时为同步回调（在方法返回之前执行回调方法）
        System.out.println("call  method  callBack");
        callBack.methodToCallBack();

        //异步回调指的是在函数返回之后执行回调函数，

        // 例如 通过第三方支付系统来实现支付功能。用户在发起支付请求后，一般不会一直阻塞等到支付结果返回。而是注册回调接口（一般是一个回调用的URL）给第三方系统，
        // 等第三方系统执行完之后，将结果通过回调接口返回给用户。



    }
}


