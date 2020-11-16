package com.example.cs320EthicsPlayer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="courses") 
@EntityListeners(AuditingEntityListener.class)
public class Courses{
    @Id
    @Column(name = "C_ID")
    private int course_ID;

    @Column(name = "Name")
    private String courseName;

    public Courses(){
        super();
    }
    public Courses(@JsonProperty("COURSE") int course_ID, @JsonProperty("NAME") String courseName){
        this.course_ID=course_ID;
        this.courseName=courseName;
    }

    public int getCID(){
        return course_ID;
    }

    public String getCourseName(){
        return courseName;
    }

    public void setCID(int cID){
        course_ID=cID;
    }

    public void setCName(String cName){
        courseName=cName;
    }
}
