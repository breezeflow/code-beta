package org.breeze.spring.common.factory;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 
 */
public class DefaultUserFactory implements UserFactory, InitializingBean,DisposableBean{

    // 基于 @PostConstruct 注解
    @PostConstruct
    public void init() {
        System.out.println("@PostConstruct : UserFactory 初始化中 ... ");
    }

    // 自定义初始化方法
    public void initUserFactory() {
        System.out.println("自定义初始化方法 initUserFactory() : UserFactory 初始化中 ... ");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean#afterPropertiesSet() initUserFactory() : UserFactory 初始化中 ... ");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("@PreDestroy : UserFactory 销毁中 ... ");
    }

    @Override
    public void destroy(){
        System.out.println("DisposableBean#destroy() : UserFactory 销毁中 ... ");
    }

    public void doDestroy(){
        System.out.println("自定义销毁方法 doDestroy() : UserFactory 销毁中 ... ");
    }
}
