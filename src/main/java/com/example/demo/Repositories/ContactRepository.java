package com.example.demo.Repositories;

import com.example.demo.Models.ContactInfo;
import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<ContactInfo, Long> {
}
