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

    /*
    * get specific column of a Student from the students id
    */
    @GetMapping("/studentDemographics/Grade/{id}")
    public String getStudentGrade(@PathVariable(value = "id") int student_ID) throws Exception{
        Demographics d = demographicsRepository.findById(student_ID)
            .orElseThrow(() -> new Exception("Student " + student_ID + " not found"));
        return d.getGrade();        
    }

    @GetMapping("/studentDemographics/Age/{id}")
    public int getStudentAge(@PathVariable(value = "id") int student_ID) throws Exception{
        Demographics d = demographicsRepository.findById(student_ID)
            .orElseThrow(() -> new Exception("Student " + student_ID + " not found"));
        return d.getAge();        
    }

    @GetMapping("/studentDemographics/Gender/{id}")
    public String getStudentGender(@PathVariable(value = "id") int student_ID) throws Exception{
        Demographics d = demographicsRepository.findById(student_ID)
            .orElseThrow(() -> new Exception("Student " + student_ID + " not found"));
        return d.getGender();        
    }

    @GetMapping("/studentDemographics/Race/{id}")
    public String getStudentRace(@PathVariable(value = "id") int student_ID) throws Exception{
        Demographics d = demographicsRepository.findById(student_ID)
            .orElseThrow(() -> new Exception("Student " + student_ID + " not found"));
        return d.getRace();        
    }

    @GetMapping("/studentDemographics/Major/{id}")
    public String getStudentMajor(@PathVariable(value = "id") int student_ID) throws Exception{
        Demographics d = demographicsRepository.findById(student_ID)
            .orElseThrow(() -> new Exception("Student " + student_ID + " not found"));
        return d.getMajor();        
    }
    
    /*update specific column of a specific student
    * 
    */
    @PutMapping("/studentDemographicsAge/{id}")
    public ResponseEntity<Demographics> updateStudentAge(@PathVariable(value="id") int student_ID, @RequestBody int age) throws Exception{
        Demographics d = demographicsRepository.findById(student_ID)
            .orElseThrow(() -> new Exception("Student " + student_ID + " not found"));

        if( age <= 0 ||age > 176 ){
            throw new Exception("Invalid input");
        }

        Demographics de = new Demographics(d.getStudentID(),0,d.getGrade(),d.getGender(), d.getRace(),d.getMajor());
        de.setAge(age);
        return ResponseEntity.ok(demographicsRepository.save(de));
    }

    //only works if you send string without {} or any ""
    @PutMapping("/studentDemographicsGrade/{id}")
    public ResponseEntity<Demographics> updateStudentGrade(@PathVariable(value = "id") int student_ID, @RequestBody String grade) throws Exception{
        Demographics d = demographicsRepository.findById(student_ID)
            .orElseThrow(() -> new Exception("Student " + student_ID + " not found"));
        if(!(grade.equals("fre")||grade.equals("sop")||grade.equals("jun")||grade.equals("sen"))){
            throw new Exception("Invalid input");
        }
        Demographics de = new Demographics(d.getStudentID(),d.getAge(),"",d.getGender(), d.getRace(),d.getMajor());
        de.setGrade(grade);
        return ResponseEntity.ok(demographicsRepository.save(de));
    }

    @PutMapping("studentDemographicsGender/{id}/{Gender}")
    public int updateStudentGender(@PathVariable(value="id") int student_ID, @PathVariable(value="Gender") String gender)
            throws Exception {
        Demographics d = demographicsRepository.findById(student_ID)
            .orElseThrow(() -> new Exception("Student " + student_ID + " not found"));
        d.setGender(gender);
        demographicsRepository.save(d);
        return 0;
    }

    @PutMapping("/studentDemographicsRace/{id}")
    public ResponseEntity<Demographics> updateStudentRace(@PathVariable(value = "id") int student_ID, @RequestBody String race) throws Exception{
        Demographics d = demographicsRepository.findById(student_ID)
            .orElseThrow(() -> new Exception("Student " + student_ID + " not found"));
        /*if(!()){
            throw new Exception("Invalid input");
        }*/
        Demographics de = new Demographics(d.getStudentID(),d.getAge(),d.getGrade(),d.getGender(), "",d.getMajor());
        de.setRace(race);
        return ResponseEntity.ok(demographicsRepository.save(de));
    }

    @PutMapping("/studentDemographicsMajor/{id}")
    public ResponseEntity<Demographics> updateStudentMajor(@PathVariable(value="id") int student_ID, @RequestBody String major) throws Exception{
        Demographics d = demographicsRepository.findById(student_ID)
            .orElseThrow(() -> new Exception("Student " + student_ID + " not found"));
        /*if(!()){
            throw new Exception("Invalid input");
        }*/
        Demographics de = new Demographics(d.getStudentID(),d.getAge(),d.getGrade(),d.getGender(), d.getRace(), "");
        de.setMajor(major);
        return ResponseEntity.ok(demographicsRepository.save(de));
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
