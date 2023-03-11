package org.breezeflow.spring.ioc;

import org.breezeflow.spring.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * <p>{@link BeanFactory} 作为IoC容器
 * <p>{@link org.springframework.context.ApplicationContext} 作为IoC容器
 *
 * @author andy
 */
@Configuration
public class IoCContainerDemo {

    public static void main(String[] args) {

//        beanFactoryAsIoCContainer();

        annotationApplicationContextAsIocContainer();
    }

    private static void annotationApplicationContextAsIocContainer() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(IoCContainerDemo.class);
        applicationContext.refresh();
        lookUpCollectionByType(applicationContext);
    }

    @Bean
    public User user() {
        return new User(1L, "andy");
    }


    public static void beanFactoryAsIoCContainer() {
        // 创建 BeanFactory 容器
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 加载配置
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);

        String location = "classpath:/META-INF/dependency-injection.xml";

        int beanDefinitionsCount = reader.loadBeanDefinitions(location);

        System.out.println("加载的bean定义的数量：" + beanDefinitionsCount);

        lookUpCollectionByType(beanFactory);
    }

    private static void lookUpCollectionByType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> userMap = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("查找到的所有User对象" + userMap);
        }
    }
}
