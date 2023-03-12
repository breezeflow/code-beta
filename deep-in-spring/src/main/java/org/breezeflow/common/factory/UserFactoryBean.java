package org.breezeflow.common.factory;

import org.breezeflow.common.domain.User;
import org.springframework.beans.factory.FactoryBean;

/**
 * {@link org.breezeflow.common.domain.User} Bean 的 {@link org.springframework.beans.factory.FactoryBean} 实现
 *
 * @author andy
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
