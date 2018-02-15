package com.example.demo.Repositories;

import com.example.demo.Models.Education;
import org.springframework.data.repository.CrudRepository;

public interface EduRepository extends CrudRepository<Education, Long> {
}
