package com.example.studentRepo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.student.StudentModel;

@Repository
public interface StudentRepo extends MongoRepository<StudentModel, String> {

	List<StudentModel> findByName(String name);
}
