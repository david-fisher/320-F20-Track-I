package com.example.cs320EthicsPlayer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "students_in")
@EntityListeners(AuditingEntityListener.class)
public class StudentsIn {
    
    @Id
    @Column(name = "Student")
    private int student_ID;

    @Column(name = "Scenario")
    private int scenario;

    @Column(name = "ScenarioVer")
    private int scenarioVer;

    @Column(name= "C_ID")
    private int course_ID;

    public StudentsIn(){
        super();
    }

    public StudentsIn(@JsonProperty("S_ID") int student_ID, @JsonProperty("C_ID") int course_ID){
        this.student_ID = student_ID;
        this.course_ID = course_ID;
        this.scenario=1;
        this.scenarioVer=1;
    }

    /*public StudentsIn(@JsonProperty("S_ID") int student_ID, @JsonProperty("scenario") int scenario, @JsonProperty("scenarioVer") int scenarioVer, @JsonProperty("C_ID") int course_ID){
        this.student_ID = student_ID;
        this.scenario=scenario;
        this.scenarioVer=scenarioVer;
        this.course_ID=course_ID;
    }*/

    public int getStudentID(){
        return student_ID;
    }

    public int getScenario(){
        return scenario;
    }

    public int getScenarioVer(){
        return scenarioVer;
    }

    public int getCourseID(){
        return course_ID;
    }

    public void setStudentID(int sID){
        student_ID = sID;
    }

    public void setScenario(int s){
        scenario=s;
    }

    public void setScenarioVer(int sV){
        scenarioVer=sV;
    }

    public void setCourseID(int cID){
        course_ID=cID;
    }

}
