package com.security.respository;

import com.security.model.Job;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by student on 7/6/17.
 */
public interface JobRepository extends CrudRepository<Job,Long>{
    List<Job> findByTitle(String title);
    List<Job> findByEmployeer(String employeer);
}
