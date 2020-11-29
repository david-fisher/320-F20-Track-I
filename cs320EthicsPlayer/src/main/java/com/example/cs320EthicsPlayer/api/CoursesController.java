package com.example.cs320EthicsPlayer.api;

import java.util.List;

import com.example.cs320EthicsPlayer.model.Courses;
import com.example.cs320EthicsPlayer.repository.CoursesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class CoursesController {

    @Autowired
    private CoursesRepository coursesRepository;

    //save new student to table
    @PostMapping("/Courses")
    public void newCoursesStu(@RequestBody Courses c){
        coursesRepository.save(c);
    }

    //get all courses
    @GetMapping("/Courses")
    public List<Courses> getAllCourses(){
        return coursesRepository.findAll();
    }

    @GetMapping("/Courses/Name/{id}")
    public String getCourseName(@PathVariable(value = "id") int course_ID) throws Exception{
        Courses c = coursesRepository.findById(course_ID)
            .orElseThrow(() -> new Exception("Course " + course_ID + " not found"));
        return c.getCourseName();
    }
    
  
    
}
