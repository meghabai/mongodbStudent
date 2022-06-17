package com.example.demo.student;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface studentsRepository extends MongoRepository <student, String>{

}

