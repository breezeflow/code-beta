package org.breezeflow.spring.bean;

import org.breezeflow.common.factory.DefaultUserFactory;
import org.breezeflow.common.factory.UserFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;

/**
 * Bean 初始化
 *
 * @author andy
 */
public class BeanInitializationDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(BeanInitializationDemo.class);

        applicationContext.refresh();
        // 非延迟加载在 spring 应用上下文启动完成后，被初始化
        System.out.println("Spring 上下文已启动 ... ");
        UserFactory userFactory = applicationContext.getBean(UserFactory.class);

        System.out.println(userFactory);
        applicationContext.close();
    }

    @Bean(initMethod = "initUserFactory",destroyMethod = "doDestroy")
    @Lazy(value = false)
    public DefaultUserFactory userFactory(){
        return new DefaultUserFactory();
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("当前 DefaultUserFactory 对象正在被垃圾回收 ... ");
    }
}
