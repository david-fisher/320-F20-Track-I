package com.example.cs320EthicsPlayer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="pages")
@EntityListeners(AuditingEntityListener.class)
public class Pages {
    
	@Id
    @Column(name="PAGE")
    private int pageID;
    
    @Column(name="PAGE_TYPE")
    private String pageType;
    
    @Column(name="PAGE_TITLE")
    private String pageTitle;
    
    @Column(name="Scenario")
    private int scenarioID;

    @Column(name="Version")
    private int scenarioVerID;
    
    @Column(name="X_COORDINATE")
    private int xCoordinate;
    
    @Column(name="Y_COORDINATE")
    private int yCoordinate;
    
    @Column(name="NEXT_PAGE")
    private int nextPageID;

    public Pages(){
        super();
    }

    public Pages(@JsonProperty("PAGE") int pageID, @JsonProperty("PAGE_TYPE") String pageType,@JsonProperty("PAGE_TITLE") String pageTitle,@JsonProperty("Scenario") int scenario,@JsonProperty("ScenarioVer") int scenarioVer,@JsonProperty("X_COORDINATE") int xCoordinate, @JsonProperty("Y_COORDINATE") int yCoordinate, @JsonProperty("NEXT_PAGE") int nextPageID){
    	this.pageID = pageID;
    	this.pageType = pageType;
        this.pageTitle = pageTitle;
        this.scenarioID = scenario;
        this.scenarioVerID = scenarioVer;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
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
        return scenarioID;
    }

    public int getScenarioVer(){
        return scenarioVerID;
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
        scenarioID=scenario_id;
    }

    public void setScenarioVer(int scenario_version){
        scenarioVerID=scenario_version;
    }

    public void setNextPageID(int next_page_id){
        nextPageID = next_page_id;
    }    
}

