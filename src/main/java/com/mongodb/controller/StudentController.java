package com.mongodb.controller;

import com.mongodb.model.Student;
import com.mongodb.service.StudentService;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Level;

@RestController
@RequestMapping("/student")
@Log
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping("/hello")
	public ResponseEntity<String> sayHello(){
		String message =" Hi All Students From Pune Univercity";
		return ResponseEntity.ok(message);
	}
	// Comment added for checking
	@PostMapping("/save")
	public ResponseEntity<String> saveStudent(@RequestBody Student student){
		Student std = studentService.createStudent(student);
		return ResponseEntity.status(HttpStatus.CREATED).body("Saved Successfully");

	}
	@GetMapping("/getMessage")
	public ResponseEntity<String> getMessage(@RequestBody Student student){
		Student std = studentService.createStudent(student);

		log.log(Level.INFO," This code is of UAT and CR-1234");

		return ResponseEntity.status(HttpStatus.CREATED).body("Saved Successfully");

	}

}