package com.example.cs320EthicsPlayer.api;

import java.util.List;

import com.example.cs320EthicsPlayer.model.ScenariosFor;
import com.example.cs320EthicsPlayer.model.ScenariosForID;

import com.example.cs320EthicsPlayer.repository.ScenariosForRepository;

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
public class ScenariosForController {
    
    @Autowired
    private ScenariosForRepository scenariosForRepository;


    @GetMapping("/getScenariosForCourse/{c_id}")
    public List<ScenariosFor> getScenariosForCourse(@PathVariable(value = "c_id") int c_id) throws Exception {
        List<ScenariosFor> scenariosForList = scenariosForRepository.findByCourse(c_id);
        return scenariosForList;
    }
}
