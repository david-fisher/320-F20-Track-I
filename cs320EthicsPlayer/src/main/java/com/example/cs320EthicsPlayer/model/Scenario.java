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
@IdClass(ScenarioID.class)
@Table(name="scenarios")
@EntityListeners(AuditingEntityListener.class)
public class Scenario {
    
	@Id
    @Column(name="E_ID")
    private int e_id;
    
    @Id
    @Column(name="VERSION_ID")
    private int version_id;
    
    @Column(name="NAME")
    private String name;
    
    @Column(name="NUM_CONVERSATIONS")
    private int num_conversations;

    @Column(name="PUBLIC")
    private boolean is_public;
    
    @Column(name="CREATOR")
    private int creator;

    public Scenario(){
        super();
    }

    public Scenario(@JsonProperty("E_ID") int e_id,@JsonProperty("VERSION_ID") int version_id,@JsonProperty("NAME") String name, @JsonProperty("NUM_CONVERSATIONS") int num_conversations,@JsonProperty("PUBLIC") boolean is_public, @JsonProperty("CREATOR") int creator){
        this.e_id = e_id;
        this.version_id = version_id;
        this.name = name;
        this.num_conversations = num_conversations;
        this.is_public=is_public;
        this.creator = creator;
    }
    
    public int getEID(){
        return e_id;
    }

    public int getVERSIONID(){
        return version_id;
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
        return creator;
    }

    public void setEID(int EID){
        e_id=EID;
    }

    public void setVERSIONID(int VERSIONID){
        version_id=VERSIONID;
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
        creator = CREATOR;
    } 
}

