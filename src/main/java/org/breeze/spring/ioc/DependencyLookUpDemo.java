package org.breeze.spring.ioc;

import org.breeze.spring.common.annotation.Super;
import org.breeze.spring.common.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * 依赖查找
 *
 * 
 */
public class DependencyLookUpDemo {

    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-lookup.xml");

        //通过注解查找
        lookUpByAnnotation(beanFactory);

        //按照类型查找
        lookUpByType(beanFactory);

        // 查找对象的集合
        lookUpCollectionByType(beanFactory);

        //实时查找
        lookUpInRealTime(beanFactory);

        //延时查找
        lookUpInLazy(beanFactory);

        // 别名查找
        lookUpByAlias(beanFactory);

        // 通过 ObjectProvider 查找
        lookUpByObjectProvider();

    }

    private static void lookUpByAlias(BeanFactory beanFactory) {
        User user = (User) beanFactory.getBean("user");
        User alias = (User) beanFactory.getBean("my_user");
        System.out.println("alias == user ? " + (alias == user));
    }

    private static void lookUpByAnnotation(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> userMap = (Map) listableBeanFactory.getBeansWithAnnotation(Super.class);
            System.out.println("查找 @Super 标注的所有User对象" + userMap);
        }
    }

    private static void lookUpCollectionByType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> userMap = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("查找到的所有User对象" + userMap);
        }
    }

    private static void lookUpByType(BeanFactory beanFactory) {
        User user = beanFactory.getBean(User.class);
        System.out.println("实时查找" + user);
    }

    private static void lookUpInRealTime(BeanFactory beanFactory) {
        User user = (User) beanFactory.getBean("user");
        System.out.println("实时查找" + user);
    }

    private static void lookUpInLazy(BeanFactory beanFactory) {
        ObjectFactory<User> objectFactory = (ObjectFactory<User>) beanFactory.getBean("objectFactory");
        User user = objectFactory.getObject();
        System.out.println("延时查找" + user);
    }

    private static void lookUpByObjectProvider() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(DependencyLookUpDemo.class);
        applicationContext.refresh();

        ObjectProvider<String> objectProvider = applicationContext.getBeanProvider(String.class);
        System.out.println(objectProvider.getObject());

        applicationContext.close();
    }

    @Bean
    public String helloWorld() { // 方法名就是 Bean 名称 "helloWorld"
        return "hello,world";
    }
}
