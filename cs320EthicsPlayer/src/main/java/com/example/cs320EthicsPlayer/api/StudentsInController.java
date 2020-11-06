package com.example.cs320EthicsPlayer.api;

import java.util.List;
import java.util.Map;

import com.example.cs320EthicsPlayer.model.StudentsIn;
import com.example.cs320EthicsPlayer.model.StudentsInID;
import com.example.cs320EthicsPlayer.repository.StudentsInRepository;

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
        studentsInRepository.save(s);
        return 1;
    } 

    @DeleteMapping("/removeStudent")
    public int removeStudentFromCourse(@RequestBody StudentsIn s) throws Exception {
        //find student findById(s.sID) then check to make sure correct cID corresponds to obj
        StudentsInID sID = new StudentsInID(s.getStudentID(),s.getCourseID());
        studentsInRepository.findById(sID)
                  .orElseThrow(() -> new Exception("Student " + s.getStudentID() +" not found in " + s.getCourseID()));
        studentsInRepository.delete(s);
        return 1;
    }

    @DeleteMapping("/removeStudent/{s_id}/{c_id}")
    public int removeStudentFromCourseByID(@PathVariable(value="s_id") int student_id,@PathVariable(value="c_id") int course_id) throws Exception{
        StudentsInID sID = new StudentsInID(student_id,course_id);
        StudentsIn s=studentsInRepository.findById(sID)
                  .orElseThrow(() -> new Exception("Student " + student_id +" not found in " + course_id));
        studentsInRepository.delete(s);
        return 1;

    }

    /*@GetMapping("/getStudentsCourse/{cID}")
    public List<Integer> getStudentsInCourse(@PathVariable int c_ID){
        //c_ID
        // figure out how to findallbycid
        return studentsInRepository.findByCourseID(c_ID);
    }*/


    // this best place for it?
    @GetMapping
    public Map<Integer,String> getAllCourses(){
        return null;
    }

}
