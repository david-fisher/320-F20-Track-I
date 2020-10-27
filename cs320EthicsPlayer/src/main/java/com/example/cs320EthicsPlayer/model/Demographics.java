package com.example.cs320EthicsPlayer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

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

    public Demographics(int student_ID, int age, String grade, String gender, String race, String major){
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
}
