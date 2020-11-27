package com.example.cs320EthicsPlayer.api;

import com.example.cs320EthicsPlayer.model.EventPage;
import com.example.cs320EthicsPlayer.model.Pages;
import com.example.cs320EthicsPlayer.repository.EventPageRepository;
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
public class EventPageController {
    
    @Autowired
    private EventPageRepository eventPageRepository;

    @Autowired
    private PagesRepository pagesRepository;

    @PostMapping("/eventpage") // POST Method for Create operation
    public EventPage createEventPage(@Validated @RequestBody EventPage event) {
      return eventPageRepository.save(event);
    }

    @GetMapping("/eventpage/{page_ID}")
    public ResponseEntity<EventPage> getPageInfoById(@PathVariable(value = "page_ID") int page_ID) throws Exception {
        EventPage ePage = eventPageRepository.findById(page_ID)
            .orElseThrow(() -> new Exception("Event page " + page_ID + " not found"));
        return ResponseEntity.ok().body(ePage);
    }

    @GetMapping("/eventpage/Intro/{page_ID}")
    public String getIntroPageText(@PathVariable(value="page_ID") int page_ID) throws Exception{
        EventPage ePage = eventPageRepository.findById(page_ID)
            .orElseThrow(() -> new Exception("Event page " + page_ID + " not found"));
        Pages p = pagesRepository.findById(page_ID)
            .orElseThrow(() -> new Exception("Page " + page_ID + " not found"));
        if(!(p.getPageType().equals("Intro"))){ throw new Exception("Incorrect Page Type");}
        return ePage.getPageInfo();
    }

    //getPtaPageText()
    @GetMapping("/eventpage/PTA/{page_ID}")
    public String getPtaPageText(@PathVariable(value="page_ID") int page_ID) throws Exception{
        EventPage ePage = eventPageRepository.findById(page_ID)
            .orElseThrow(() -> new Exception("Event page " + page_ID + " not found"));
        Pages p = pagesRepository.findById(page_ID)
            .orElseThrow(() -> new Exception("Page " + page_ID + " not found"));
        if(!(p.getPageType().equals("INTRO"))){ throw new Exception("Incorrect Page Type");}
         return ePage.getPageInfo();
    }

    //getSummaryPageText()
    @GetMapping("eventpage/Summary/{page_ID}")
    public String getSummaryPageText(@PathVariable(value="page_ID") int page_ID) throws Exception{
        EventPage ePage = eventPageRepository.findById(page_ID)
            .orElseThrow(() -> new Exception("Event page " + page_ID + " not found"));
        Pages p = pagesRepository.findById(page_ID)
            .orElseThrow(() -> new Exception("Page " + page_ID + " not found"));
        if(!(p.getPageType().equals("SUMMARY"))){ throw new Exception("Incorrect Page Type");}
        return ePage.getPageInfo();
    }

    //getFeedBackPageText()
    @GetMapping("eventpage/Feedback/{page_ID}")
    public String getFeedBackPageText(@PathVariable(value="page_ID") int page_ID) throws Exception{
        EventPage ePage = eventPageRepository.findById(page_ID)
            .orElseThrow(() -> new Exception("Event page " + page_ID + " not found"));
        Pages p = pagesRepository.findById(page_ID)
            .orElseThrow(() -> new Exception("Page " + page_ID + " not found"));
        if(!(p.getPageType().equals("FEEDBACK"))){ throw new Exception("Incorrect Page Type");}
        return ePage.getPageInfo();
    }

}
