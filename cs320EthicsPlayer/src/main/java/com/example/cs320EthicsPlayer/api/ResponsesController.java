package com.example.cs320EthicsPlayer.api;

import java.util.List;

import com.example.cs320EthicsPlayer.model.Responses;
import com.example.cs320EthicsPlayer.model.ResponsesID;
import com.example.cs320EthicsPlayer.repository.ResponsesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ResponsesController {
    
    @Autowired
	ResponsesRepository responsesRepository;

    @GetMapping("/responses")
    public List<Responses> getAllResponses() {
        return responsesRepository.findAll();
    }
    
    //gets all the responses for a specific scenario 
    @GetMapping("/scenarioResponses/{scenario}")
    public List<Responses> getAllResponsesForScenario(@PathVariable(value = "scenario") int scenario) {
    	List<Responses> allResponses = responsesRepository.findByScenario(scenario);
        return allResponses;
    }
    
    //gets all responses taken by a student
    @GetMapping("/studentResponses/{student}")
    public List<Responses> getAllResponsesByStudent(@PathVariable(value = "student") int student) {
    	List<Responses> allResponsesByStudent = responsesRepository.findByStudent(student);
        return allResponsesByStudent;
    }
    
    //addStudentResponse()
    @PostMapping("/addStudentResponse")
    public Responses addStudentResponse(@Validated @RequestBody Responses studentResponse) throws Exception{
    	 return responsesRepository.save(studentResponse);
    }
}
   