package com.security.respository;

/**
 * Created by student on 7/5/17.
 */
import com.security.model.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role,Long>{
    Role findByRole(String role);
}