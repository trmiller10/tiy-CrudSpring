package com.theironyard;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Taylor on 6/11/16.
 */

public interface UserRepository extends CrudRepository<User, Integer>{
}
