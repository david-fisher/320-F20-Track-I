package com.example.cs320EthicsPlayer.api;

import java.util.List;

import com.example.cs320EthicsPlayer.model.ActionPage;
import com.example.cs320EthicsPlayer.model.Pages;
import com.example.cs320EthicsPlayer.repository.ActionPageRepository;
import com.example.cs320EthicsPlayer.repository.PagesRepository;

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
public class ActionPageController {
    
    @Autowired
    private ActionPageRepository actionPageRepository;

    @Autowired
    private PagesRepository pagesRepository;
    
    @PostMapping("/actionpage") // POST Method for Create operation
    public ActionPage createActionPage(@Validated @RequestBody ActionPage action) {
      return actionPageRepository.save(action);
    }
    
    @GetMapping("/actionpage/{page_ID}")
    public List<ActionPage> getPageInfoById(@PathVariable(value = "page_ID") int page_ID) throws Exception {
        List<ActionPage> aPages = actionPageRepository.findByPageID(page_ID);
        return aPages;
    }
    
}
    
    