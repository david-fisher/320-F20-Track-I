package com.example.cs320EthicsPlayer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@IdClass(ConversationsID.class)
@Table(name="conversations")
@EntityListeners(AuditingEntityListener.class)
public class Conversations {
    
    @Id
    @Column(name="STAKEHOLDER")
    int stakeholder;

    @Id
    @Column(name="CONVERSATION")
    int convo;

    @Column(name="QUESTION")
    String question;

    @Column(name="RESPONSE")
    String response;

    public Conversations(){
        super();
    }

    public Conversations(@JsonProperty("STAKEHOLDER") int stk, @JsonProperty("CONVERSATION") int convo, @JsonProperty("QUESTION") String qs, @JsonProperty("RESPONSE") String response){
        this.stakeholder=stk;
        this.convo=convo;
        this.question=qs;
        this.response=response;
    }

    public int getStakeholder(){
        return stakeholder;
    }

    public int getConvo(){
        return convo;
    }

    public String getQuestion(){
        return question;
    }

    public String getResponse(){
        return response;
    }

    public void setStakeholder(int stk){
        stakeholder = stk;
    }

    public void setConvo(int c){
        convo=c;
    }

    public void setQuestion(String q){
        question=q;
    }

    public void setResponse(String r){
        response=r;
    }
}
