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
@IdClass(EventPageID.class)
@Table(name="generic_page")
@EntityListeners(AuditingEntityListener.class)
public class EventPage{

    @Id
    @Column(name="PAGE")
    private int pageID;

    @Id
    @Column(name="BODY")
    private String pageInfo;

    public EventPage(){
        super();
    }

    public EventPage(@JsonProperty("PAGE") int page_ID, @JsonProperty("BODY") String pageInfo){
        this.pageID=page_ID;
        this.pageInfo=pageInfo;
    }

    public int getPageID(){
        return pageID;
    }

    public String getPageInfo(){
        return pageInfo;
    }
}