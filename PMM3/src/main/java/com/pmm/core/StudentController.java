package com.pmm.core;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.pmm.exceptions.StudentNotFound;

import com.pmm.core.Student;
import com.pmm.core.StudentService;


@RestController

public class StudentController 
{//DEPENDENCY INJECTION USING AUTOWIRING
 
 @Autowired
 private StudentService studentService;//reference variable

	@PostMapping("/student")
	public ResponseEntity<String> createStudent(@RequestBody Student student) {
		String status = studentService.upsert(student);
		return new ResponseEntity<>(status, HttpStatus.CREATED);
	}

	@GetMapping("/student/{id}")
	public ResponseEntity<Student> getStudent(@PathVariable Integer id) {
		Student student = studentService.getById(id);
		return new ResponseEntity<>(student, HttpStatus.OK);
	}

	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAllStudents() {
		List<Student> allStudents = studentService.getAllStudents();
		return new ResponseEntity<>(allStudents, HttpStatus.OK);
	}

	@PutMapping("/student")
	public ResponseEntity<String> updateStudent(@RequestBody Student student) {
		String status = studentService.upsert(student);
		return new ResponseEntity<>(status, HttpStatus.OK);
	}

	@DeleteMapping("/student/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable Integer id) {
		String status = studentService.deleteById(id);
		return new ResponseEntity<>(status, HttpStatus.OK);
	}

	

 
}
