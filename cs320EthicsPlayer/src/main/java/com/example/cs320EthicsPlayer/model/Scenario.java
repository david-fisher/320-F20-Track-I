package com.example.cs320EthicsPlayer.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.example.cs320EthicsPlayer.api.ScenarioController;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@IdClass(ScenarioID.class)
@Table(name="scenarios")
@EntityListeners(AuditingEntityListener.class)
public class Scenario {
    
	@Id
    @Column(name="SCENARIO")
    private int scenario;
    
    @Id
    @Column(name="VERSION")
    private int version;
    
    @Column(name="NAME")
    private String name;
    
    @Column(name="NUM_CONVERSATIONS")
    private int num_conversations;

    @Column(name="PUBLIC")
    private boolean is_public;
    
    @Column(name="PROFESSOR")
    private int professor;

    @Column(name="DATE_CREATED")
    private Date created;

    @Column(name="IS_FINISHED")
    boolean isFinished;

    public Scenario(){
        super();
    }

    public Scenario(@JsonProperty("SCENARIO") int scenario,@JsonProperty("VERSION") int version,@JsonProperty("NAME") String name, @JsonProperty("NUM_CONVERSATIONS") int num_conversations,@JsonProperty("PUBLIC") boolean is_public, @JsonProperty("CREATOR") int professor, @JsonProperty("DATE_CREATED") Date created, @JsonProperty("IS_FINISHED") boolean isFinished){
        this.scenario = scenario;
        this.version = version;
        this.name = name;
        this.num_conversations = num_conversations;
        this.is_public=is_public;
        this.professor = professor;
        this.created=created;
        this.isFinished=isFinished;
    }
    
    public int getScenarioID(){
        return scenario;
    }

    public int getVERSIONID(){
        return version;
    }

    public String getNAME(){
        return name;
    }

    public int getNUMCONVERSATIONS(){
        return num_conversations;
    }

    public boolean getPUBLIC(){
        return is_public;
    }
    
    public int getCREATOR(){
        return professor;
    }

    public void setScenarioID(int EID){
        scenario=EID;
    }

    public void setVERSIONID(int VERSIONID){
        version=VERSIONID;
    }

    public void setName(String NAME){
        name=NAME;
    }

    public void setNUMCONVERSATIONS(int NUMCONVERSATIONS){
        num_conversations=NUMCONVERSATIONS;
    }

    public void setPublic(boolean PUBLIC){
        is_public = PUBLIC;
    }    
    
    public void setCreator(int CREATOR){
        professor = CREATOR;
    } 
}

