package com.mongodb.controller;

import com.mongodb.model.Student;
import com.mongodb.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping("/hello")
	public ResponseEntity<String> sayHello(){
		String message =" Hi All Students From Pune Univercity";
		log.info("Inside say Hello method {}",message);
		return ResponseEntity.ok(message);
	}

	@PostMapping("/save")
	public ResponseEntity<String> saveStudent(@RequestBody Student student){
		Student std = studentService.createStudent(student);
		log.info("inside save method  {}", std);
		return ResponseEntity.status(HttpStatus.CREATED).body("Saved Successfully");

	}

	@GetMapping("/getallstudent")
	public ResponseEntity<List<Student>> getAllStudent(){
		List<Student> stdl = studentService.getAllStudent();
		return ResponseEntity.ok(stdl);

	}

	@GetMapping("/getbyid/{id}")
	public ResponseEntity<?> getById(@PathVariable String id){
		Optional<Student> std = studentService.getstdById(id);
		if(std.isPresent()){
			return ResponseEntity.ok(std.get());
		} else {
			String msg = "Student for is found";
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
		}
//		return std.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<String> updatebyid(@PathVariable  String id,@RequestBody Student std){
		studentService.updatestdbyid(id,std);
		return ResponseEntity.ok("Student Updated Succesfully");
	}

	@DeleteMapping("/deletebyid/{id}")
	public ResponseEntity<String> deletebyid(@PathVariable String id){
		studentService.deletebyid(id);
		return ResponseEntity.ok("Student Deleted Succesfully");
	}

}
