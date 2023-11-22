package com.example.studentController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.student.StudentModel;
import com.example.studentService.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentService studentService;

	@GetMapping("/getByName/{name}")
	public List<StudentModel> getBySytudent(@PathVariable("name") String name) {
		return studentService.findByName(name);

	}

	@PostMapping("/post")
	public StudentModel post(@RequestBody StudentModel student) {
		return studentService.post(student);
	}

}
