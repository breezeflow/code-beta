回调应用举例：

1. jdbcTemplate

JdbcTemplate 通过回调的机制，将不变的执行流程抽离出来，放到模板方法 execute()中，
将可变的部分设计成回调 StatementCallback，由用户来定制。
query() 函数是对 execute() 函数的二次封装，让接口用起来更加方便。

2.  添加监听器

android开发中，有时会给某个按钮添加点击事件。
```java
Button button = findViewById(button.id);
buton.setOnClickListener(new OnClickListener(){

    @Override
    public void onClick(View v){
        System.out.println("i'am clicked")
    }    

});
```
这里的回调算是异步回调，注册之后不需要等回调函数执行，只有用户执行完点击操作就会调用。异步回调比较像观察者模式。


模板模式和回调的比较：

从应用场景来看，基本相同，都是为了起到复用和扩展的目的。

区别在于：回调基于组合关系来实现，需要吧一个对象传递给另外一个对象，而模板模式基于继承关系来实现的。