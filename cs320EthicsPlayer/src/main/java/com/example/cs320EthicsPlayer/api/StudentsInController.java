package com.example.cs320EthicsPlayer.api;

import java.util.List;
import java.util.Map;

import com.example.cs320EthicsPlayer.model.StudentsIn;
import com.example.cs320EthicsPlayer.repository.StudentsInRepository;
//import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class StudentsInController {
    
    @Autowired
    private StudentsInRepository studentsInRepository;

    @PostMapping("/addStudentToC")
    public int addStudentToCourse(@RequestBody StudentsIn s){
        //int cID=s.getCourseID();
        studentsInRepository.save(s);
        return 1;
    } 

    @DeleteMapping("/removeStudent")
    public int removeStudentFromCourse(@RequestBody StudentsIn s){
        //find student findById(s.sID) then check to make sure correct cID corresponds to obj
        studentsInRepository.delete(s);
        return 1;
    }

    @GetMapping("/getStudentsCourse/{cID}")
    public List<Integer> getStudentsInCourse(@PathVariable int c_ID){
        //c_ID
        // figure out how to findallbycid
        return null;
    }


    // this best place for it?
    @GetMapping
    public Map<Integer,String> getAllCourses(){
        return null;
    }

}
