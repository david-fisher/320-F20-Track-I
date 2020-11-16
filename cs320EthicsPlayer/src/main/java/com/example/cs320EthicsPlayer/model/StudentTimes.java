//package com.example.cs320EthicsPlayer.model;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.EntityListeners;
//import javax.persistence.Id;
//import javax.persistence.IdClass;
//import javax.persistence.Table;
//import java.sql.date;
//
//import com.fasterxml.jackson.annotation.JsonProperty;
//
//import org.springframework.data.jpa.domain.support.AuditingEntityListener;
//
//@Entity
//@IdClass(StudentsTimeID.class)
//@Table(name = "students_times")
//@EntityListeners(AuditingEntityListener.class)
//public class StudentTimes {
//
//    @Id
//    @Column(name = "STUDENT")
//    private int studentID;
//
//    @Id
//    @Column(name= "COURSE")
//    private int courseID;
//
//    @Id
//    @Column(name = "Scenario")
//    private int scenarioID;
//
//    @Id
//    @Column(name = "Version")
//    private int versionID;
//
//    @Id
//    @Column(name = "DATE_TAKEN")
//    private Date date;
//
//    @Id
//    @Column(name = "PAGE")
//    private int pageID;
//
//    @Column(name = "StartTime")
//    private Date startTime;
//
//    @Column(name = "EndTime")
//    private Date endTime;
//
//    public StudentTimes(){
//        super();
//    }
//
//    public StudentTimes(@JsonProperty("STUDENT") int student_ID, @JsonProperty("COURSE") int course_ID, @JsonProperty("Scenario") int scen, @JsonProperty("Version") int ver, @JsonProperty("DATE_TAKEN") Date date, @JsonProperty("PAGE") int page, @JsonProperty("StartTime") Date start, @JsonProperty("EndTime") Date end" {
//        this.studentID = student_ID;
//        this.courseID = course_ID;
//        this.scenarioID = scen;
//        this.versionID = ver;
//        this.date = date;
//        this.pageID = page;
//        this.startTime = start;
//        this.endTime = end;
//
//    }
//
//    public int getStudentID(){
//        return studentID;
//    }
//
//    public int getCourseID(){
//        return courseID;
//    }
//
//    public int getScenarioID(){
//        return scenarioID;
//    }
//
//    public int getVersionID(){
//        return versionID;
//    }
//
//    public Date getDate(){
//        return date;
//    }
//
//    public int getPage(){
//        return pageID;
//    }
//
//    public int getStartTime(){
//        return startTime;
//    }
//
//    public int getEndTime(){
//        return endTime;
//    }
//
//    public void setStudentID(int sID){
//        studentID = sID;
//    }
//
//    public void setCourseID(int cID){
//        courseID=cID;
//    }
//
//    public void setScenarioID(int sID){
//        scenarioID = sID;
//    }
//
//    public void setVersionID(int vID){
//        versionID = vID;
//    }
//
//    public void setDate(Date d){
//        date = d;
//    }
//
//    public void setPage(int p){
//        pageID = p;
//    }
//
//    public void setStartTime(Date s){
//        startTime = s;
//    }
//
//    public void setEndTime(Date e){
//        endTime = e;
//    }
//}