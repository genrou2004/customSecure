package com.security.respository;


import com.security.model.Education;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by student on 6/29/17.
 */
public interface EducationRepository extends CrudRepository<Education,Integer> {
    List<Education> findByEmail(String email);
}
