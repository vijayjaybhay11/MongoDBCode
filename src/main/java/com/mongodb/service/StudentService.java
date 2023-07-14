package com.mongodb.service;

import com.mongodb.dto.StudentRepository;
import com.mongodb.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student createStudent(Student student){
        return studentRepository.save(student);
    }

    public List<Student> getAllStudent(){
        List<Student> stdlist = studentRepository.findAll();
        return  stdlist;
    }

    @Cacheable(value="students",key="#id")
    public Optional<Student> getstdById(String id){
        log.info("inside getcall for 1st time");
        return studentRepository.findById(id);
    }

    public Student updatestdbyid(String id,Student std){

        std.setCity(std.getCity());
        studentRepository.save(std);
        return std;
    }

    public void  deletebyid(String id){
        studentRepository.deleteById(id);
    }
}
