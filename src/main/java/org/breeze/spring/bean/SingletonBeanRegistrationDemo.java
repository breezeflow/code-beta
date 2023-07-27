package org.breeze.spring.bean;

import org.breeze.spring.common.factory.DefaultUserFactory;
import org.breeze.spring.common.factory.UserFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author andy
 */
public class SingletonBeanRegistrationDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        // 注册外部单例对象
        UserFactory userFactory = new DefaultUserFactory();
        ConfigurableListableBeanFactory beanFactory = applicationContext.getBeanFactory();
        beanFactory.registerSingleton("userFactory",userFactory);

        applicationContext.refresh();


        UserFactory userFactoryByLookUp = beanFactory.getBean("userFactory",UserFactory.class);

        System.out.println("userFactory == userFactoryByLookUp ? " + (userFactoryByLookUp == userFactory));


        applicationContext.close();


    }
}
