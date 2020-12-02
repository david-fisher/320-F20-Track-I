package com.example.cs320EthicsPlayer.api;

import java.util.List;

import com.example.cs320EthicsPlayer.repository.ConversationsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ConversationsController {
    
    @Autowired
    ConversationsRepository conversationsRepository;

    //getSpecificStakeholderConversations()

    @GetMapping("/getSpecificStakeholdersConvos/{cID}/{scen}/{vers}")
    public List<Integer> getSpecificStakeholderConversations(){
        return null;
    }
    
}
