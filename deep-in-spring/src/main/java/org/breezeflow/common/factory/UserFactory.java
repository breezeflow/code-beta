package org.breezeflow.common.factory;

import org.breezeflow.common.domain.User;

/**
 * @author andy
 */
public interface UserFactory {

    default User createUser() {
        return User.createUser();
    }

}
