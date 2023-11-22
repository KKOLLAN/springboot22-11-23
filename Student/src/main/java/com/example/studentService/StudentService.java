package com.example.studentService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.student.StudentModel;
import com.example.studentRepo.StudentRepo;

@Service
public class StudentService {

	@Autowired
	StudentRepo repo;

	public List<StudentModel> findByName(String name) {
		return repo.findByName(name);
	}

	public StudentModel post(StudentModel student) {
		return repo.save(student);
	}

	public StudentModel put(StudentModel student) {
		return repo.save(student);
	}

	public String deleteStudent(String name) {
		List<StudentModel> list = repo.findByName(name);
		repo.deleteAll(list);
		return "deleted";
	}
}
