package com.example.cs320EthicsPlayer.api;

import java.util.List;

import com.example.cs320EthicsPlayer.model.Conversations;
import com.example.cs320EthicsPlayer.model.ConversationsID;
import com.example.cs320EthicsPlayer.repository.ConversationsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ConversationsController {
    
    @Autowired
    ConversationsRepository conversationsRepository;

    //getSpecificStakeholderConversations()
//
//    @GetMapping("/getSpecificStakeholdersConvos/{stk}/{convo}")
//    public Conversations getSpecificStakeholderConversations(@PathVariable(value="stk") int stk, @PathVariable(value="convo") int convo) {
//        ConversationsID a = new ConversationsID(stk, convo);
//        Conversations b = conversationsRepository.findById(a);
//        return b;
//    }
    
    @GetMapping("/getSpecificStakeholdersConvos/{stk}")
    public List<Conversations> getStakeholderConversations(@PathVariable(value="stk") int stk){
        return conversationsRepository.findByStakeholder(stk);
    }
    
}
