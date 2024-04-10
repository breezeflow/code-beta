package org.breeze.spring.common.factory;

import org.breeze.spring.common.domain.User;
import org.springframework.beans.factory.FactoryBean;

/**
 * {@link org.breeze.spring.common.domain.User} Bean 的 {@link org.springframework.beans.factory.FactoryBean} 实现
 *
 * 
 */
public class UserFactoryBean implements FactoryBean<User> {
    @Override
    public User getObject() throws Exception {
        return User.createUser();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
