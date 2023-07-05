package org.breeze.spring.bean;

import org.breeze.common.domain.User;
import org.breeze.common.factory.DefaultUserFactory;
import org.breeze.common.factory.UserFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * Bean 实例化
 *
 * @author andy
 */
public class BeanInstantiationDemo {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("src/main/resources/META-INF/bean-instantiation-context.xml");

        User user = applicationContext.getBean("user-by-static-method", User.class);
        User bean = applicationContext.getBean("user-by-instance-method", User.class);
        User factoryBean = applicationContext.getBean("user-by-factory-bean", User.class);

        System.out.println(user);

        System.out.println(bean);

        System.out.println(factoryBean);

        System.out.println(user == bean);

        System.out.println(user == factoryBean);

        // 通过 ServiceLoader 来实例化 Bean
        System.out.println("-----通过ServiceLoader来实例化Bean-----");
        ServiceLoader<UserFactory> serviceLoader = applicationContext.getBean("userFactoryServiceLoader", ServiceLoader.class);
        demoServiceLoader();
        displayServiceLoader(serviceLoader);

        // 通过 AutowireCapableBeanFactory 创建 Bean
        AutowireCapableBeanFactory beanFactory = applicationContext.getAutowireCapableBeanFactory();
        UserFactory userFactory = beanFactory.createBean(DefaultUserFactory.class);
        System.out.println(userFactory.createUser());
    }

    public static void demoServiceLoader() {
        ServiceLoader<UserFactory> serviceLoader = ServiceLoader.load(UserFactory.class, Thread.currentThread().getContextClassLoader());
        displayServiceLoader(serviceLoader);
    }

    private static void displayServiceLoader(ServiceLoader<UserFactory> serviceLoader) {
        Iterator<UserFactory> iterator = serviceLoader.iterator();
        while (iterator.hasNext()) {
            UserFactory userFactory = iterator.next();
            System.out.println(userFactory.createUser());
        }
    }


}
