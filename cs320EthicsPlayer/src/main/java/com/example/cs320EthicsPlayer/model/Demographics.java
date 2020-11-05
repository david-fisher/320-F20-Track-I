package com.example.cs320EthicsPlayer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="demographics")
@EntityListeners(AuditingEntityListener.class)
public class Demographics {
    
    @Id
    @Column(name = "S_ID")
    private int student_ID;

    @Column(name = "AGE")
    private int age;

    @Column(name = "GRADE")
    private String grade;

    @Column(name = "GENDER")
    private String gender;

    @Column(name = "RACE")
    private String race;

    @Column(name = "MAJOR")
    private String major;

    public Demographics(){
        super();
    }

    public Demographics(@JsonProperty("S_ID") int student_ID){
        super();
        this.student_ID=student_ID;
    }

    public Demographics(@JsonProperty("S_ID") int student_ID, @JsonProperty("AGE") int age, @JsonProperty("GRADE") String grade, @JsonProperty("GENDER") String gender, @JsonProperty("RACE") String race, @JsonProperty("MAJOR") String major){
        this.student_ID=student_ID;
        this.age=age;
        this.grade=grade;
        this.gender=gender;
        this.race=race;
        this.major=major;
    }

    public int getStudentID(){
        return student_ID;
    }

    public int getAge(){
        return age;
    }

    public String getGender(){
        return gender;
    }

    public String getRace(){
        return race;
    }

    public String getMajor(){
        return major;
    }

    public String getGrade(){
        return grade;
    }

    public void setGrade(@JsonProperty("GRADE") String g){
        grade=g;
    }
}
