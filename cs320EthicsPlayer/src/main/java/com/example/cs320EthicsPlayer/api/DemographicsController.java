package com.example.cs320EthicsPlayer.api;

import java.util.List;

import com.example.cs320EthicsPlayer.model.Demographics;
import com.example.cs320EthicsPlayer.repository.DemographicsRepository;

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
public class DemographicsController {

    @Autowired
    private DemographicsRepository demographicsRepository;

    //save new student to table
    @PostMapping("/studentDemographics")
    public void newDemographicStu(@RequestBody Demographics d){
        demographicsRepository.save(d);
    }

    //get all students
    @GetMapping("/studentDemographics")
    public List<Demographics> getAllStudentDemographics(){
        return demographicsRepository.findAll();
    }

    //get specific student by student id
    @GetMapping("/studentDemographics/{id}")
    public ResponseEntity<Demographics> getStudentDemographicsById(@PathVariable(value = "id") int student_ID) throws Exception{
        Demographics d = demographicsRepository.findById(student_ID)
            .orElseThrow(() -> new Exception("Student " + student_ID + " not found"));
        return ResponseEntity.ok().body(d);
    }

    @GetMapping("/studentDemographics/Grade/{id}")
    public String getStudentGrade(@PathVariable(value = "id") int student_ID) throws Exception{
        Demographics d = demographicsRepository.findById(student_ID)
            .orElseThrow(() -> new Exception("Student " + student_ID + " not found"));
        return d.getGrade();        
    }

    /*update specific column of a specific student 
    */
    public int updateStudentAge(int student_ID, int age){
        return 0;
    }

    //only works if you send string without {} or any ""
    @PutMapping("/studentDemographicsGrade/{id}")
    public ResponseEntity<Demographics> updateStudentGrade(@PathVariable(value = "id") int student_ID, @RequestBody String grade) throws Exception{
        Demographics d = demographicsRepository.findById(student_ID)
            .orElseThrow(() -> new Exception("Student " + student_ID + " not found"));
        /*if(!(grade=="fre"||grade=="sop"||grade=="jun"||grade=="sen")){
            throw new Exception("Invalid input");
        }*/
        Demographics de = new Demographics(d.getStudentID(),d.getAge(),"",d.getGender(), d.getRace(),d.getMajor());
        de.setGrade(grade);
        return ResponseEntity.ok(demographicsRepository.save(de));
    }

    //return obj for now
    @PutMapping("studentDemographicsGender/{id}/{Gender}")
    public int updateStudentGender(@PathVariable(value="id") int student_ID, @PathVariable(value="Gender") String gender)
            throws Exception {
        Demographics d = demographicsRepository.findById(student_ID)
            .orElseThrow(() -> new Exception("Student " + student_ID + " not found"));
        d.setGender(gender);
        demographicsRepository.save(d);
        return 0;
    }

    public int updateStudentRace(int student_ID, String race){
         Demographics d = demographicsRepository.findById(student_ID)
            .orElseThrow(() -> new Exception("Student " + student_ID + " not found"));
        d.setRace(race);
        demographicsRepository.save(d);
        return 0;
    }

    public int updateStudentMajor(int student_ID, String major){
        Demographics d = demographicsRepository.findById(student_ID)
            .orElseThrow(() -> new Exception("Student " + student_ID + " not found"));
        d.setMajor(major);
        demographicsRepository.save(d);
        return 0;
    }
    
    /* these methods will get all rows with a certain input for the column ie all demographics of a certain major
    */

    @GetMapping("/studentDemographicsGrade/{Grade}")
    public List<Demographics> findAllByGrade(@PathVariable(value="Grade") String grade){
        return demographicsRepository.findByGrade(grade);
    }

    @GetMapping("/studentDemographicsGender/{Gender}")
    public List<Demographics> findAllByGender(@PathVariable(value="Gender") String gender){
        return demographicsRepository.findByGender(gender);
    }

    @GetMapping("/studentDemographicsRace/{Race}")
    public List<Demographics> findAllByRace(@PathVariable(value="Race") String race){
        return demographicsRepository.findByRace(race);
    }   
    
    @GetMapping("/studentDemographicsAge/{Age}")
    public List<Demographics> findAllByAge(@PathVariable(value="Age") int age){
        return demographicsRepository.findByAge(age);
    }

    @GetMapping("/studentDemographicsMajor/{Major}")
    public List<Demographics> findAllByMajor(@PathVariable(value="Major") String major){
        return demographicsRepository.findByMajor(major);
    }

}
