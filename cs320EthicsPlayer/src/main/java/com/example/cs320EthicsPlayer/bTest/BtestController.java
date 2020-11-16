package com.example.cs320EthicsPlayer.bTest;

import java.util.List;

import com.example.cs320EthicsPlayer.model.Student;

import com.example.cs320EthicsPlayer.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.cs320EthicsPlayer.api.StudentController;

/**
 * @Author: ZJendex
 * @Time: 11/15/2020, Sun
 **/

@RestController
@RequestMapping("/api/v1")
public class BtestController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping(value = "/ss")
    public List<Student> test1() throws Exception {
        StudentController s = new StudentController();
        return studentRepository.findAll();
    }

    @GetMapping(value = "/sss")
    public ResponseEntity<Student> test2() throws Exception {
        StudentController s = new StudentController();
        return s.getStudentById(123);
    }
}
