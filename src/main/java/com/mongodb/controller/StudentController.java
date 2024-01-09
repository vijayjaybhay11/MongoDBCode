package com.mongodb.controller;

import com.mongodb.model.Student;
import com.mongodb.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping("/hello")
	public ResponseEntity<String> sayHello(){
		String message =" Hi All Students From Pune Univercity";
		// log.info("Inside say Hello method {}",message);
		log.info("new log added",message);
		return ResponseEntity.ok(message);
	}

	@PostMapping("/save")
	public ResponseEntity<String> saveStudent(@RequestBody Student student){
		Student std = studentService.createStudent(student);
		log.info("inside save method  {}", std);
		return ResponseEntity.status(HttpStatus.CREATED).body("Saved Successfully");

	}
}
