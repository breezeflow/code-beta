package org.breezeflow.spring.bean;

import org.breezeflow.common.domain.User;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * 注册 BeanDefinition 示例
 *
 * @author andy
 */
@Import(AnnotationBeanDefinitionDemo.Config.class)
public class AnnotationBeanDefinitionDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        // 注册 配置类，通过 @Bean 的方式定义
        // 通过 @Component 的方式定义
        // 通过 @Import 的方式导入
        applicationContext.register(Config.class);

        // 通过 BeanDefinition 注册 API 实现
        registryBeanDefinition(applicationContext, "api_user");
        registryBeanDefinition(applicationContext);

        applicationContext.refresh();

        Map<String, Config> configMap = applicationContext.getBeansOfType(Config.class);
        Map<String, User> userMap = applicationContext.getBeansOfType(User.class);

        System.out.println("Config 类型的所有 beans " + configMap);
        System.out.println("User 类型的所有 beans " + userMap);

        applicationContext.close();
    }

    public static void registryBeanDefinition(BeanDefinitionRegistry registry,
                                              String beanName) {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        builder.addPropertyValue("id", 4L).addPropertyValue("name", "猪八戒");

        // 注册 BeanDefinition
        if (StringUtils.hasText(beanName)) {
            registry.registerBeanDefinition(beanName, builder.getBeanDefinition());
        } else {
            // 非命名 Bean 注册方法
            BeanDefinitionReaderUtils.registerWithGeneratedName(builder.getBeanDefinition(), registry);
        }
    }

    public static void registryBeanDefinition(BeanDefinitionRegistry registry) {
        registryBeanDefinition(registry, null);
    }


    @Component
    public static class Config {

        @Bean
        public User user() {
            return new User(1L, "andy");
        }
    }
}
