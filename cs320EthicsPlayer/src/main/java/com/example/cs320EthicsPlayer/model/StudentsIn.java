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
@IdClass(StudentsInID.class)
@Table(name = "students_in")
@EntityListeners(AuditingEntityListener.class)
public class StudentsIn {
    
    @Id
    @Column(name = "Student")
    private int studentID;

    @Id
    @Column(name= "C_ID")
    private int courseID;

    public StudentsIn(){
        super();
    }

    public StudentsIn(@JsonProperty("S_ID") int student_ID, @JsonProperty("C_ID") int course_ID){
        this.studentID = student_ID;
        this.courseID = course_ID;
    }

    public int getStudentID(){
        return studentID;
    }

    public int getCourseID(){
        return courseID;
    }

    public void setStudentID(int sID){
        studentID = sID;
    }

    public void setCourseID(int cID){
        courseID=cID;
    }
}

