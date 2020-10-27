package com.example.cs320EthicsPlayer.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.cs320EthicsPlayer.model.Reflections;
import com.example.cs320EthicsPlayer.model.ReflectionsID;
import com.example.cs320EthicsPlayer.repository.ReflectionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
public class ReflectionsController {
    
    @Autowired
    private ReflectionRepository reflectionRepository;

    @GetMapping("/reflections")
    public List<Reflections> getAllReflections(){
        return reflectionRepository.findAll();
    }

    @GetMapping("/reflections/{id}")
    public ResponseEntity<Reflections> getReflectionById(@PathVariable(value = "id") ReflectionsID id) throws Exception {
        Reflections reflect = reflectionRepository.findById(id)
            .orElseThrow(() -> new Exception("Reflection "+ id + " not found"));
        return ResponseEntity.ok().body(reflect);
    }

    @PostMapping("/reflections")
    public Reflections createReflection(@Validated @RequestBody Reflections reflect){
        return reflectionRepository.save(reflect);
    }

    @PutMapping("/reflections/{id}")
    public ResponseEntity<Reflections> updateReflection(@PathVariable(value="id")ReflectionsID id,@RequestBody Reflections reflectDetails) throws Exception {
        Reflections reflect =reflectionRepository.findById(id)
            .orElseThrow(() -> new Exception("Reflection " + id + " not found"));
        
        reflect.setReflections(reflectDetails.getReflections());    
        reflect.setCID(reflectDetails.getCID());
        reflect.setEID(reflectDetails.getSID());
        reflect.setDate(reflectDetails.getDate());

        final Reflections updatedReflection= reflectionRepository.save(reflect);
        return ResponseEntity.ok(updatedReflection);
    }

    @DeleteMapping("/reflections/{id}")
    public Map<String,Boolean> deleteReflection(@PathVariable(value = "id") ReflectionsID id) throws Exception{
        Reflections reflect =reflectionRepository.findById(id)
            .orElseThrow(() -> new Exception("Reflection " + id + " not found"));
        
        reflectionRepository.delete(reflect);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }


}