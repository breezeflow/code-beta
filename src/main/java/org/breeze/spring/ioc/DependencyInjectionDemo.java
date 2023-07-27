package org.breeze.spring.ioc;

import org.breeze.spring.common.dao.UserDao;
import org.breeze.spring.common.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

/**
 * 依赖注入
 *
 * @author andy
 */
public class DependencyInjectionDemo {

    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-injection.xml");

        // 依赖来源一：自定义bean
        UserDao userDao = beanFactory.getBean("userDao", UserDao.class);
        System.out.println(userDao);

        // 依赖来源二：依赖注入的 beanFactory (容器的内建依赖，非spring的bean)
        System.out.println(userDao.getBeanFactory());
        System.out.println(userDao.getBeanFactory() == beanFactory);

        // 依赖查找的 beanFactory 会报错
        // 这说明 依赖查找和依赖注入的依赖不同源
        // 且 beanFactory 并不是一个普通的bean
//        System.out.println(beanFactory.getBean(BeanFactory.class));

        ObjectFactory<User> userObjectFactory = userDao.getUserObjectFactory();
        System.out.println(userObjectFactory.getObject());

        ObjectFactory objectFactory = userDao.getObjectFactory();
        System.out.println(objectFactory.getObject());

        // 依赖来源三：容器内建bean
        Environment environment = beanFactory.getBean(Environment.class);
        System.out.println(environment);
    }

}
