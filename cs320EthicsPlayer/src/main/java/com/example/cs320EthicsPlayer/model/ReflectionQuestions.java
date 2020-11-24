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
@IdClass(ReflectionQuestionsID.class)
@Table(name="reflection_questions")
@EntityListeners(AuditingEntityListener.class)
public class ReflectionQuestions {
    
    @Id
    @Column(name="PAGE")
    private int pageID;

    @Id
    @Column(name="REFLECTION_QUESTION")
    private String reflectionQ;

    public ReflectionQuestions(){
        super();
    }
    
    public ReflectionQuestions(@JsonProperty("PAGE") int page_ID, @JsonProperty("REFLECTION_QUESTION") String reflectionQ){
        this.pageID=page_ID;
        this.reflectionQ=reflectionQ;
    }

    public int getPageID(){
        return pageID;
    }

    public String getReflectionQuestion(){
        return reflectionQ;
    }

    public void setReflectionQuestion(String refQ){
        reflectionQ= refQ;
    }
}