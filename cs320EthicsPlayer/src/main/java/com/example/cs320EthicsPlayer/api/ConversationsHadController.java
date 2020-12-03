package com.example.cs320EthicsPlayer.api;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.example.cs320EthicsPlayer.model.ConversationsHad;
import com.example.cs320EthicsPlayer.model.ConversationsHadID;
import com.example.cs320EthicsPlayer.repository.ConversationsHadRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    //int sID, int cID, int scen, int vers, Date date, int stk, double score, int convo
    @PostMapping("/addStakeholder")
    public int  addStakeholderToStudentsList(@RequestBody ConversationsHad a){
        //ConversationsHad a = new ConversationsHad(sID, cID, scen, vers, date,stk, score, convo);
        conversationsHadRepository.save(a);
        return 1;
    }
    
  @GetMapping("/getStakeholders/{sID}")
  public List<ConversationsHad> getStudentsStakeholderList(@PathVariable(value="sID") int sID){
      List<ConversationsHad> a = conversationsHadRepository.findByStudent(sID);
      return a;
  }

//    @GetMapping("/getStakeholders/{sID}/{cID}/{scen}/{vers}/{date}")
//    public List<Integer> getStudentsStakeholderList(@PathVariable(value="sID") int sID, @PathVariable(value="cID") int cID, @PathVariable(value="scen") int scen, @PathVariable(value="vers") int vers, @PathVariable(value="date") Date date){
//        List<ConversationsHad> a = conversationsHadRepository.findByStudentANDCourseANDScenarioANDVersionANDDate(sID,cID,scen,vers,date);
//        List<Integer> b= new ArrayList<Integer>();
//        for(ConversationsHad t: a){
//            b.add(t.getStakeholder());
//        }
//        return b;
//    }
//
//    @DeleteMapping("/removeStakeholder/{sID}/{cID}/{scen}/{vers}/{date}/{stk}")
//    public void removeStakeholderFromStudentsList(@PathVariable(value="sID") int sID, @PathVariable(value="cID") int cID, @PathVariable(value="scen") int scen, @PathVariable(value="vers") int vers, @PathVariable(value="date") Date date, @PathVariable(value="stk") int stakeholder)
//            throws Exception {
//        ConversationsHadID a = new ConversationsHadID(sID, cID, scen, vers, date);
//        ConversationsHad c = conversationsHadRepository.findById(a)
//            .orElseThrow(() -> new Exception("ConversationsHad not found") );
//        conversationsHadRepository.delete(c);
//    }

}
