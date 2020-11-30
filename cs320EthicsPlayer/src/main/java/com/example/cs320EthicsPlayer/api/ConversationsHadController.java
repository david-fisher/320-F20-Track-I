package com.example.cs320EthicsPlayer.api;

import java.sql.Date;

import com.example.cs320EthicsPlayer.model.ConversationsHad;
import com.example.cs320EthicsPlayer.repository.ConversationsHadRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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
    @PostMapping("/addStakeholder")
    public int  addStakeholderToStudentsList(int sID, int cID, int scen, int vers, Date date, int stk, double score, int convo){
        ConversationsHad a = new ConversationsHad(sID, cID, scen, vers, date,stk, score, convo);
        conversationsHadRepository.save(a);
        return 1;
    }

//getStudentsStakeholderList()
//removeStakeholderFromStudentsList()

}
