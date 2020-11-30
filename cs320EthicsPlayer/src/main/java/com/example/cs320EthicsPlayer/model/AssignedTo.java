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
@IdClass(AssignedToID.class)
@Table(name = "assigned_to")
@EntityListeners(AuditingEntityListener.class)
public class AssignedTo {
    
    @Id
    @Column(name = "STUDENT")
    private int studentID;

    @Id
    @Column(name= "SCENARIO")
    private int scenarioID;
    
    @Id
    @Column(name= "VERSION")
    private int versionID;

    public AssignedTo(){
        super();
    }

    public AssignedTo(@JsonProperty("STUDENT") int student_ID, @JsonProperty("SCENARIO") int scenarioID, @JsonProperty("VERSION") int versionID){
        this.studentID = student_ID;
        this.scenarioID = scenarioID;
        this.versionID = versionID;
    }

    public int getStudentID(){
        return studentID;
    }

    public int getScenario(){
        return scenarioID;
    }
    
    public int getVersion(){
        return versionID;
    }

}

