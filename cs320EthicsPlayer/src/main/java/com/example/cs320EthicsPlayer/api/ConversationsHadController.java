package com.example.cs320EthicsPlayer.api;

import com.example.cs320EthicsPlayer.repository.ConversationsHadRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ConversationsHadController {

    @Autowired
    ConversationsHadRepository conversationsHadRepository;
    

    //addStakeholderToStudentsList()
    /*When a user chooses to have a conversation with one of the stakeholders, 
    *this call will add the stakeholder to the list of stakeholders that the 
    *student has talked too.
    */
    public int  addStakeholderToStudentsList(int sID, int cID, int scen, int vers, int stk, int convo){
        return 0;
    }

//getStudentsStakeholderList()
//removeStakeholderFromStudentsList()

}
