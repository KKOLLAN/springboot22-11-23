package com.example.hello.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.hello.bean.StudentModel;

@RestController
public class StudentController {

	@GetMapping("Student")
	public StudentModel getStudent() {
		StudentModel student = new StudentModel(1, "kiran", "kollana");
		return student;
	}

	@GetMapping("S")
	public ResponseEntity<List<StudentModel>> getStudents() {
		List<StudentModel> students = new ArrayList<>();
		students.add(new StudentModel(1, "Ramesh", "Fadatare"));
		students.add(new StudentModel(2, "umesh", "Fadatare"));
		students.add(new StudentModel(3, "Ram", "Jadhav"));
		students.add(new StudentModel(4, "Sanjay", "Pawar"));
		return ResponseEntity.ok(students);
	}

	@GetMapping("{id}/{first-name}/{last-name}")
	public ResponseEntity<StudentModel> studentPathVariable(@PathVariable("id") int studentId,
			@PathVariable("first-name") String firstName, @PathVariable("last-name") String lastName) {
		StudentModel student = new StudentModel(studentId, firstName, lastName);
		return ResponseEntity.ok(student);
	}

	@GetMapping("query")
	public ResponseEntity<StudentModel> studentRequestVariable(@RequestParam int id, @RequestParam String firstName,
			@RequestParam String lastName) {
		StudentModel student = new StudentModel(id, firstName, lastName);
		return ResponseEntity.ok(student);
	}

	@PostMapping("create")
	public StudentModel createStudent(@RequestBody StudentModel student) {
		System.out.println(student.getId());
		System.out.println(student.getFirstName());
		System.out.println(student.getLastName());
		return student;
	}
	 @PutMapping("{id}/update")
	    public ResponseEntity<StudentModel> updateStudent(@RequestBody StudentModel student, @PathVariable("id") int studentId){
	        System.out.println(student.getFirstName());
	        System.out.println(student.getLastName());
	        return ResponseEntity.ok(student);
	    }

	    
	    @DeleteMapping("{id}/delete")
	    public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId){
	        System.out.println(studentId);
	        return ResponseEntity.ok("Student deleted successfully!");
	    }
}
