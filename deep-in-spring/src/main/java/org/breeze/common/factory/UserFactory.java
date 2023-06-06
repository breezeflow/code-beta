package org.breeze.common.factory;

import org.breeze.common.domain.User;

/**
 * @author andy
 */
public interface UserFactory {

    default User createUser() {
        return User.createUser();
    }

}
