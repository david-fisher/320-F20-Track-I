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
@IdClass(ScenariosForID.class)
@Table(name = "scenarios_for")
@EntityListeners(AuditingEntityListener.class)
public class ScenariosFor {
    
    @Id
    @Column(name = "scenario")
    private int scenario;

    @Id
    @Column(name= "version")
    private int version;
    
    @Id
    @Column(name= "course")
    private int course;

    public ScenariosFor(){
        super();
    }

    public ScenariosFor(@JsonProperty("scenario") int scenarioID, @JsonProperty("version") int versionID, @JsonProperty("course") int courseID){
        this.scenario = scenarioID;
        this.version = versionID;
        this.course = courseID;
    }

    public int getScenarioID(){
        return scenario;
    }
    
    public int getVersionID(){
        return version;
    }

    public int getCourseID(){
        return course;
    }
    
    public void setScenarioID(int scenarioID){
        scenario = scenarioID;
    }

    public void setVersionID(int versionID){
        version = versionID;
    }

    public void setCourseID(int courseID){
        course = courseID;
    }

}

