package com.theironyard.services;

import com.theironyard.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Taylor on 6/11/16.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Integer>{

    User findByUserNameAndPassword(String userName, String password);
    User findByUserName(String userName);
}
