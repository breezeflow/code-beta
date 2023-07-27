package org.breeze.spring.common.factory;

import org.breeze.spring.common.domain.User;

/**
 * @author andy
 */
public interface UserFactory {

    default User createUser() {
        return User.createUser();
    }

}
