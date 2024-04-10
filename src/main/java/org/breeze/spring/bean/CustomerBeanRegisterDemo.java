package org.breeze.spring.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 注册一个自定义的 Bean 到 Spring
 *
 * 
 * 
 */
public class CustomerBeanRegisterDemo {

    public static void main(String[] args) {
        ApplicationContext beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/bean-instantiation-context.xml");
        IUserDao userDao = beanFactory.getBean("userDao", IUserDao.class);
        String res = userDao.queryNameById();
        System.out.println(res);
    }

}


class CustomerBeanRegisterFactory implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(UserFactoryBean.class);

        BeanDefinitionHolder definitionHolder = new BeanDefinitionHolder(beanDefinition, "userDao");
        BeanDefinitionReaderUtils.registerBeanDefinition(definitionHolder, registry);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {

    }
}


interface IUserDao {

    String queryNameById();

}

class UserFactoryBean implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Class[] classes = {IUserDao.class};
        InvocationHandler handler = (proxy, method, args) -> "IUserDao#" + method.getName() + " 被代理了";

        return Proxy.newProxyInstance(classLoader, classes, handler);
    }

    @Override
    public Class<?> getObjectType() {
        return IUserDao.class;
    }
}
