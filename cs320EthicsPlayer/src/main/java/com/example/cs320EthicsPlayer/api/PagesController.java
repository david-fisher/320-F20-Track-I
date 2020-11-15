package com.example.cs320EthicsPlayer.api;

import java.util.List;

import com.example.cs320EthicsPlayer.model.Pages;
import com.example.cs320EthicsPlayer.repository.PagesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class PagesController {
    
    @Autowired
    private PagesRepository pagesRepository;

    //getPageTitle()
    @GetMapping("/PageTitle/{page_ID}")
    public String getPageTitle(@PathVariable(value="page_ID") int page_ID) throws Exception{
        Pages p = pagesRepository.findById(page_ID)
            .orElseThrow(() -> new Exception("Page " + page_ID +" not found"));
        return p.getPageTitle();
    }

    //getPageType()
    @GetMapping("/PageType/{page_ID}")
    public String getPageType(@PathVariable(value="page_ID") int page_ID) throws Exception{
        Pages p = pagesRepository.findById(page_ID)
            .orElseThrow(() -> new Exception("Page " + page_ID +" not found"));
        return p.getPageType();
    }

    //getNextPage()
    @GetMapping("/NextPage/{page_ID}")
    public int getNextPage(@PathVariable(value="page_ID") int page_ID) throws Exception{
        Pages p = pagesRepository.findById(page_ID)
            .orElseThrow(() -> new Exception("Page " + page_ID +" not found"));
        return p.getNextPageID();
    }

    //returns a List of all pageIDs for a specific scenario
    @GetMapping("/AllPageId/{scenario}/{scenarioVer}")
    public List<Pages> getPageIDsByScenario(@PathVariable(value="scenario") int scenario, @PathVariable(value="scenarioVer") int scenarioVer){
        
        return pagesRepository.findByScenarioIDAndScenarioVerID(scenario, scenarioVer);
        
    }

    @GetMapping("/Intro/PageID/{scenario}/{scenarioVer}")
    public int getIntroPageID(@PathVariable(value="scenario") int scenario, @PathVariable(value="scenarioVer") int scenarioVer){
        List<Pages>p= pagesRepository.findByScenarioIDAndScenarioVerIDAndPageType(scenario,scenarioVer, "INTRO");
        return p.get(0).getPageID();

    }

    @GetMapping("/PageIDs/{scenario}/{scenarioVer}/{pageType}")
    public List<Pages> getPageIDsByType(@PathVariable(value="scenario") int scenario, @PathVariable(value="scenarioVer") int scenarioVer, @PathVariable(value="pageType") String pageType){
        return pagesRepository.findByScenarioIDAndScenarioVerIDAndPageType(scenario,scenarioVer, pageType);
    }
    @PostMapping("/Pages")
    public Pages createPage(@RequestBody Pages page){
        return pagesRepository.save(page);
    }
}
