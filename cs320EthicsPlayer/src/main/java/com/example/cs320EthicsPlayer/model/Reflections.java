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
@IdClass(ReflectionsID.class)
@Table(name="reflections_taken")
@EntityListeners(AuditingEntityListener.class)
public class Reflections {
    
    @Id
    @Column(name="REFLECTIONS")
    private String reflections;
    
    @Id
    @Column(name="STUDENT")
    private int sID;
    
    @Id
    @Column(name="COURSE")
    private int cID;
    
    @Id
    @Column(name="Scenario")
    private int scenario;

    @Id
    @Column(name="Version")
    private int version;

    @Id
    @Column(name="DATE_TAKEN")
    private Date date;

    public Reflections(){
        super();
    }

    public Reflections(@JsonProperty("reflections") String reflections,@JsonProperty("S_ID") int student_id,@JsonProperty("C_ID") int course_id,@JsonProperty("E_ID") int e_id,@JsonProperty("Date") Date date, @JsonProperty("Version") int version){
        this.reflections = reflections;
        this.sID = student_id;
        this.cID = course_id;
        this.scenario = e_id;
        this.version = version;
        this.date=date;
    }
    
    public String getReflections(){
        return reflections;
    }

    public int getSID(){
        return sID;
    }
    
    public int getVersion(){
        return version;
    }

    public int getCID(){
        return cID;
    }

    public int getEID(){
        return scenario;
    }

    public Date getDate(){
        return date;
    }

    public void setReflections(String reflect){
        reflections=reflect;
    }

    public void setSID(int student_ID){
        sID=student_ID;
    }

    public void setCID(int course_ID){
        cID=course_ID;
    }

    public void setEID(int eID){
        scenario=eID;
    }

    public void setDate(Date newDate){
        date = newDate;
    }  
    
    public void setVersion(int version_){
        version=version_;
    }
}

