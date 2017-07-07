package com.security.respository;

import com.security.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by student on 7/5/17.
 */
public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);
    User findByEmail(String email);
    Long countByEmail(String email);
    Long countByUsername(String username);
    List<User> findByFirstName(String fName);
}
