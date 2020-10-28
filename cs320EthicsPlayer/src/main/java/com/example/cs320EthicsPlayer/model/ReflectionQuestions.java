package com.example.cs320EthicsPlayer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="reflection_questions")
@EntityListeners(AuditingEntityListener.class)
public class ReflectionQuestions {
    
    @Id
    @Column(name="PAGE_ID")
    private int page_ID;

    @Column(name="REFLECTION_QUESTION")
    private String reflectionQ;

    public ReflectionQuestions(){
        super();
    }
    
    public ReflectionQuestions(@JsonProperty("id") int page_ID, @JsonProperty("txt") String reflectionQ){
        this.page_ID=page_ID;
        this.reflectionQ=reflectionQ;
    }

    public int getPageID(){
        return page_ID;
    }

    public String getReflectionQuestion(){
        return reflectionQ;
    }

    public void setReflectionQuestion(String refQ){
        reflectionQ= refQ;
    }
}