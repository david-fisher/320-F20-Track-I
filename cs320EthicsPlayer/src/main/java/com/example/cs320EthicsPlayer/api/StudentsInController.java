package com.example.cs320EthicsPlayer.api;

import java.util.List;

import com.example.cs320EthicsPlayer.model.StudentsIn;
import com.example.cs320EthicsPlayer.model.StudentsInID;
import com.example.cs320EthicsPlayer.repository.StudentRepository;
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

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/addStudentToC")
    public int addStudentToCourse(@RequestBody StudentsIn s) throws Exception{
        studentRepository.findById(s.getStudentID())
            .orElseThrow(()-> new Exception("Student "+ s.getStudentID() +" not found"));
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

    @GetMapping("/getStudentsInCourse/{c_id}")
    public List<Integer> getStudentsInCourse(@PathVariable("c_id") int c_id){
        return studentsInRepository.findBycourseID(c_id);
    }

    @GetMapping ("getCoursesOfStudent/{s_id}")
    public List<Integer> getCoursesInStudent(@PathVariable("s_id") int s_id) throws Exception {
        studentRepository.findById(s_id)
            .orElseThrow(()-> new Exception("Student "+ s_id +" not found"));
        return studentsInRepository.findBystudentID(s_id);
    }
}
