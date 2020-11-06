package com.example.cs320EthicsPlayer.api;

import com.example.cs320EthicsPlayer.model.EventPage;
import com.example.cs320EthicsPlayer.repository.EventPageRepository;

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

    @PostMapping("/eventpage") // POST Method for Create operation
    public EventPage createEventPage(@Validated @RequestBody EventPage event) {
      return eventPageRepository.save(event);
    }

    @GetMapping("/eventpage/{page_ID}")
    public ResponseEntity<EventPage> getPageInfoById(@PathVariable(value = "page_ID") int page_ID) throws Exception {
        EventPage reflectQs = eventPageRepository.findById(page_ID)
            .orElseThrow(() -> new Exception("Reflection questions from " + page_ID + " not found"));
        return ResponseEntity.ok().body(reflectQs);
    }
}
