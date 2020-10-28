package com.example.cs320EthicsPlayer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="event_page")
@EntityListeners(AuditingEntityListener.class)
public class EventPage{

    @Id
    @Column(name="PAGE_ID")
    private int page_ID;

    @Column(name="BODY")
    private String pageInfo;

    public EventPage(){
        super();
    }

    public EventPage(@JsonProperty("id") int page_ID, @JsonProperty("text") String pageInfo){
        this.page_ID=page_ID;
        this.pageInfo=pageInfo;
    }

    public int getPageID(){
        return page_ID;
    }

    public String getPageInfo(){
        return pageInfo;
    }
}