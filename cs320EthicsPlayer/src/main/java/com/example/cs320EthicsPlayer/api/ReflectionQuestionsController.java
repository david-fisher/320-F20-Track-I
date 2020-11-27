package com.example.cs320EthicsPlayer.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.cs320EthicsPlayer.model.ReflectionQuestions;
import com.example.cs320EthicsPlayer.repository.ReflectionQuestionsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ReflectionQuestionsController {
    
    @Autowired
    private ReflectionQuestionsRepository reflectQRepository;

    @GetMapping("/reflectionquestions")
    public List<ReflectionQuestions> getAllReflections(){
        return reflectQRepository.findAll();
    }    

    @GetMapping("/reflectionquestions/{page_ID}")
    public ResponseEntity<ReflectionQuestions> getReflectionById(@PathVariable(value = "page_ID") int page_ID) throws Exception {
        ReflectionQuestions reflectQs = reflectQRepository.findById(page_ID)
            .orElseThrow(() -> new Exception("Reflection questions from " + page_ID + " not found"));
        return ResponseEntity.ok().body(reflectQs);
    }

    @PostMapping("/reflectionquestions")
    public ReflectionQuestions createReflection(@RequestBody ReflectionQuestions reflectQ){
        return reflectQRepository.save(reflectQ);
    }

    @PutMapping("/reflectionquestions/{page_ID}")
    public ResponseEntity<ReflectionQuestions> updateReflection(@PathVariable(value="page_ID")int page_ID,@RequestBody ReflectionQuestions reflectQDetails) throws Exception {
        ReflectionQuestions reflectQ =reflectQRepository.findById(page_ID)
            .orElseThrow(() -> new Exception("Reflection questions from " + page_ID + " not found"));
        
        reflectQ.setReflectionQuestion(reflectQDetails.getReflectionQuestion());    


        final ReflectionQuestions updatedReflectionQ= reflectQRepository.save(reflectQ);
        return ResponseEntity.ok(updatedReflectionQ);
    }

    @DeleteMapping("/reflectionquestions/{id}")
    public Map<String,Boolean> deleteReflection(@PathVariable(value = "id") int page_ID) throws Exception{
        ReflectionQuestions reflectQ =reflectQRepository.findById(page_ID)
            .orElseThrow(() -> new Exception("Reflection questions from " + page_ID + " not found"));
        
            reflectQRepository.delete(reflectQ);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
