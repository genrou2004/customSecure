package com.security.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

/**
 * Created by student on 7/6/17.
 */
@Entity
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    private String employeer;
    private double salary_range;
    private String description;
//    private List<Skills> skillsList;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmployeer() {
        return employeer;
    }

    public void setEmployeer(String employeer) {
        this.employeer = employeer;
    }

    public double getSalary_range() {
        return salary_range;
    }

    public void setSalary_range(double salary_range) {
        this.salary_range = salary_range;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
