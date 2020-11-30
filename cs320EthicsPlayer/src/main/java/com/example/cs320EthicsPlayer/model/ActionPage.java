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
@IdClass(ActionPageID.class)
@Table(name="action_page")
@EntityListeners(AuditingEntityListener.class)
public class ActionPage{

    @Id
    @Column(name="PAGE")
    private int pageID;

    @Id
    @Column(name="CHOICE")
    private String choice;
    
    @Column(name="RESULT_PAGE")
    private int resultPage;

    public ActionPage(){
        super();
    }

    public ActionPage(@JsonProperty("PAGE") int page_ID, @JsonProperty("CHOICE") String actionchoice, @JsonProperty("RESULT_PAGE") int result_page ){
        this.pageID=page_ID;
        this.choice=actionchoice;
        this.resultPage=result_page;
    }

    public int getPageID(){
        return pageID;
    }

    public String getChoice(){
        return choice;
    }
    
    public int getResultPage(){
        return resultPage;
    }
}