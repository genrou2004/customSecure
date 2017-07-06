package com.security.respository;

import com.security.model.Job;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by student on 7/6/17.
 */
public interface JobRepository extends CrudRepository<Job,Integer>{
}
