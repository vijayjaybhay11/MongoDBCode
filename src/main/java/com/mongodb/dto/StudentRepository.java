package com.mongodb.dto;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mongodb.model.Student;

public interface StudentRepository extends MongoRepository<Student,String> {
}
