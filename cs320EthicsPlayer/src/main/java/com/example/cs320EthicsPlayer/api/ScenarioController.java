package com.example.cs320EthicsPlayer.api;

import java.util.List;

import com.example.cs320EthicsPlayer.model.Scenario;
import com.example.cs320EthicsPlayer.model.ScenarioID;
import com.example.cs320EthicsPlayer.repository.ScenarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ScenarioController {
    
    @Autowired
    ScenarioRepository scenarioRepository;

    //getScenarioName()
    @GetMapping("/ScenarioName/{eID}/{vID}")
    public String getScenarioName(@PathVariable(value="eID") int eID, @PathVariable(value="vID") int vID) throws Exception{
        ScenarioID sID = new ScenarioID(eID,vID);
        Scenario s = scenarioRepository.findById(sID)
            .orElseThrow(()-> new Exception("Scenario "+ eID+ ", " + vID + " not found"));
        return s.getNAME();
    }
    
    //getPublicScenarios()
    @GetMapping("/PublicScenarios")
    public List<Scenario> getPublicScenarios(){
        return scenarioRepository.findByisPublic(true);
    }

    //getMaxNumOfConvos()
    @GetMapping("MaxNumConvos{eID}/{vID}")
    public int getMaxNumOfConvos(@PathVariable(value="eID") int eID, @PathVariable(value="vID") int vID) throws Exception{
        ScenarioID sID = new ScenarioID(eID,vID);
        Scenario s = scenarioRepository.findById(sID)
            .orElseThrow(()-> new Exception("Scenario "+ eID+ ", " + vID + " not found"));
        return s.getNUMCONVERSATIONS();
    }
}
