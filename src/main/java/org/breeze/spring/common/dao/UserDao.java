package org.breeze.spring.common.dao;

import lombok.Data;
import org.breeze.spring.common.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;

import java.util.Collection;

/**
 * @author andy
 */
@Data
public class UserDao {

    // 自定义 bean
    private Collection<User> users;

    // 内建非 bean 对象
    private BeanFactory beanFactory;

    private ObjectFactory<User> userObjectFactory;

    private ObjectFactory<ApplicationContext> objectFactory;

}
