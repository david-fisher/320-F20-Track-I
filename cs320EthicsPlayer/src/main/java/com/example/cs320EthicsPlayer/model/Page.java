package com.example.cs320EthicsPlayer.model;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="pages")
@EntityListeners(AuditingEntityListener.class)
public class Pages {
    
	@Id
    @Column(name="PAGE_ID")
    private int pageID;
    
    @Column(name="PAGE_TYPE")
    private String pageType;
    
    @Column(name="PAGE_TITLE")
    private String pageTitle;
    
    @Column(name="Scenario")
    private int scenario;

    @Column(name="ScenarioVer")
    private int scenarioVer;
    
    @Column(name="NEXT_PAGE_ID")
    private int nextPageID;

    public Pages(){
        super();
    }

    public Pages(@JsonProperty("PAGE_ID") int pageID, @JsonProperty("PAGE_TYPE") String pageType,@JsonProperty("PAGE_TITLE") String pageTitle,@JsonProperty("Scenario") int scenario,@JsonProperty("ScenarioVer") int scenarioVer,@JsonProperty("NEXT_PAGE_ID") int nextPageID){
    	this.pageID = pageID;
    	this.pageType = pageType;
        this.pageTitle = pageTitle;
        this.scenario = scenario;
        this.scenarioVer = scenarioVer;
        this.nextPageID=nextPageID;
    }
    
    public int getPageID(){
        return pageID;
    }
    
    public String getPageType(){
        return pageType;
    }

    public String getPageTitle(){
        return pageTitle;
    }

    public int getScenario(){
        return scenario;
    }

    public int getScenarioVer(){
        return scenarioVer;
    }

    public int getNextPageID(){
        return nextPageID;
    }
    
    public void setPageID(int page_id){
        pageID=page_id;
    }

    public void setPageType(String page_type){
        pageType=page_type;
    }

    public void setPageTitle(String page_title){
        pageTitle=page_title;
    }

    public void setScenario(int scenario_id){
        scenario=scenario_id;
    }

    public void setScenarioVer(int scenario_version){
        scenarioVer=scenario_version;
    }

    public void setNextPageID(int next_page_id){
        nextPageID = next_page_id;
    }    
}

