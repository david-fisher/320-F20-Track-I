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
        return ReponsesRepository.findAll();
    }
    
    //addStudentResponse()
    @PostMapping("/addStudentResponse")
    public Responses addStudentResponse(@Validated @RequestBody Responses studentResponse) throws Exception{
    	 return responsesRepository.save(studentResponse);
    }
}
   