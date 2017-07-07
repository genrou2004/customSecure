package com.security.respository;




import com.security.model.Experience;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by student on 6/29/17.
 */
public interface ExperienceRepository extends CrudRepository<Experience,Integer> {
    List<Experience> findByEmail(String email);
    List<Experience> findByCompanyName(String companyName);
}
