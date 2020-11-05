package com.example.cs320EthicsPlayer.api;

import java.util.List;

import com.example.cs320EthicsPlayer.model.Demographics;
import com.example.cs320EthicsPlayer.repository.DemographicsRepository;
import com.fasterxml.jackson.annotation.JsonProperty;

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

    @GetMapping("/studentDemographics")
    public List<Demographics> getAllStudentDemographics(){
        return demographicsRepository.findAll();
    }

    @GetMapping("/studentDemographics/{id}")
    public ResponseEntity<Demographics> getStudentDemographicsById(@PathVariable(value = "id") int student_ID) throws Exception{
        Demographics d = demographicsRepository.findById(student_ID)
            .orElseThrow(() -> new Exception("Student " + student_ID + " not found"));
        return ResponseEntity.ok().body(d);
    }

    @PostMapping("/studentDemographics")
    public void newDemographicStu(@RequestBody Demographics d){
        demographicsRepository.save(d);
    }

    public int updateStudentAge(int student_ID, int age){
        return 0;
    }

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

    @GetMapping("/studentDemographics/Grade/{id}")
    public String getStudentGrade(@PathVariable(value = "id") int student_ID) throws Exception{
        Demographics d = demographicsRepository.findById(student_ID)
            .orElseThrow(() -> new Exception("Student " + student_ID + " not found"));
        return d.getGrade();        
    }

    @GetMapping("/studentDemographicsGrade/{Grade}")
    public List<Demographics> findAllByGrade(@PathVariable(value="Grade") String grade){
        return demographicsRepository.findByGrade(grade);
    }

    public int updateStudentGender(int student_ID, String gender){
        return 0;
    }

    public int updateStudentRace(int student_ID, String race){
        return 0;
    }

    public int updateStudentMajor(int student_ID, String major){
        return 0;
    }
}
