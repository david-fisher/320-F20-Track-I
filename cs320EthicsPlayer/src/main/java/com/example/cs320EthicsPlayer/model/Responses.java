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
@IdClass(ResponsesID.class)
@Table(name="responses")
@EntityListeners(AuditingEntityListener.class)
public class Responses {
    
	@Id
    @Column(name="student")
    private int student;
    
    @Id
    @Column(name="scenario")
    private int scenario;
    
    @Id
    @Column(name="version")
    private int version;
    
    @Id
    @Column(name="course")
    private int course;

    @Id
    @Column(name="date_taken")
    private Date dateTaken;
    
    @Column(name="choice")
    private String choice;

    public Responses(){
        super();
    }

    public Responses(@JsonProperty("student") int student,@JsonProperty("scenario") int scenario,@JsonProperty("version") int version, @JsonProperty("course") int course,@JsonProperty("date_taken") Date date_taken, @JsonProperty("choice") String choice){
        this.student = student;
        this.scenario = scenario;
        this.version = version;
        this.course = course;
        this.dateTaken=date_taken;
        this.choice = choice;
    }
    
    public int getStudentID(){
        return student;
    }

    public int getScenario(){
        return scenario;
    }

    public int getVersion(){
        return version;
    }

    public int getCourse(){
        return course;
    }

    public Date getDateTaken(){
        return dateTaken;
    }
    
    public String getChoice(){
        return choice;
    }


}

