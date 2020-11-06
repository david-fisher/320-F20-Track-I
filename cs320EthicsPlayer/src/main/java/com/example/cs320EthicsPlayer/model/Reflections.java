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
    
    @Column(name="REFLECTIONS")
    private String reflections;
    
    @Id
    @Column(name="S_ID")
    private int s_ID;
    
    @Id
    @Column(name="C_ID")
    private int c_ID;
    
    @Id
    @Column(name="E_ID")
    private int e_ID;

    @Column(name="DATE_TAKEN")
    private Date date;

    public Reflections(){
        super();
    }

    public Reflections(@JsonProperty("reflections") String reflections,@JsonProperty("S_ID") int student_id,@JsonProperty("C_ID") int course_id,@JsonProperty("E_ID") int e_id,@JsonProperty("Date") Date date){
        this.reflections = reflections;
        this.s_ID = student_id;
        this.c_ID = course_id;
        this.e_ID = e_id;
        this.date=date;
    }
    
    public String getReflections(){
        return reflections;
    }

    public int getSID(){
        return s_ID;
    }

    public int getCID(){
        return c_ID;
    }

    public int getEID(){
        return e_ID;
    }

    public Date getDate(){
        return date;
    }

    public void setReflections(String reflect){
        reflections=reflect;
    }

    public void setSID(int student_ID){
        s_ID=student_ID;
    }

    public void setCID(int course_ID){
        c_ID=course_ID;
    }

    public void setEID(int eID){
        e_ID=eID;
    }

    public void setDate(Date newDate){
        date = newDate;
    }    
}

