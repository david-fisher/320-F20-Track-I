package com.example.cs320EthicsPlayer.api;

import com.example.cs320EthicsPlayer.model.Pages;
import com.example.cs320EthicsPlayer.repository.PagesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

    //getPageSubtitle()
    @GetMapping("PageSubtitle/{page_ID}")
    public String getPageSubtitle(@PathVariable(value="page_ID") int page_ID) throws Exception{
        Pages p = pagesRepository.findById(page_ID)
            .orElseThrow(() -> new Exception("Page " + page_ID +" not found"));
        //!!!!    
        //cannot find subtitle in schema !!

        return "";
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

}
