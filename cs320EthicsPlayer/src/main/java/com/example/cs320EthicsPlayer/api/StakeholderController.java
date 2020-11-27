package com.example.cs320EthicsPlayer.api;

import java.util.List;

import com.example.cs320EthicsPlayer.model.ScenarioID;
import com.example.cs320EthicsPlayer.model.Stakeholders;
import com.example.cs320EthicsPlayer.repository.StakeholderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class StakeholderController {
    
    @Autowired
    StakeholderRepository stakeholderRepository;

    //getAllStakeholdersInScenario()
    @GetMapping("/AllStakeholdersIn/{sID}")
    public List<Stakeholders> getAllStakeholdersInScenario(@PathVariable(value="sID") int sID) {
        return stakeholderRepository.findByScenario(sID);
    }

    //getStakeholderName()
    @GetMapping("/StakeholderName/{stk_ID}")
    public String getStakeholderName(@PathVariable(value="stk_ID") int stk_ID) throws Exception {
        Stakeholders s = stakeholderRepository.findById(stk_ID)
            .orElseThrow(()-> new Exception("Stakholder "+stk_ID+ " not found"));        
        return s.getName();
    }

    //getSpecificStakeholderDescription()
    @GetMapping("/StakeholderDescription/{stk_ID}")
    public String getSpecificStakeholderDescription(@PathVariable(value="stk_ID") int stk_ID) throws Exception{
        Stakeholders s = stakeholderRepository.findById(stk_ID)
            .orElseThrow(()-> new Exception("Stakholder "+stk_ID+ " not found"));   
        return s.getDescription();
    }
    
    //getSpecificStakeholderIntroduction()
    @GetMapping("/StakeholderIntroduction/{stk_ID}")
    public String getSpecificStakeholderIntroduction(@PathVariable(value="stk_ID") int stk_ID) throws Exception{
        Stakeholders s = stakeholderRepository.findById(stk_ID)
            .orElseThrow(()-> new Exception("Stakholder "+stk_ID+ " not found"));   
        return s.getIntroduction();
    }

    //getStakeholderJob()
    @GetMapping("/StakeholderJob/{stk_ID}")
    public String getStakeholderJob(@PathVariable(value="stk_ID") int stk_ID) throws Exception{
        Stakeholders s = stakeholderRepository.findById(stk_ID)
            .orElseThrow(()-> new Exception("Stakholder "+stk_ID+ " not found")); 
        return s.getJob();
    }

}
