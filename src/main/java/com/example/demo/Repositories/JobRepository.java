package com.example.demo.Repositories;

import com.example.demo.Models.Job;
import org.springframework.data.repository.CrudRepository;

public interface JobRepository extends CrudRepository<Job, Long> {

}
