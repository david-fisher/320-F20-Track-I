package com.example.cs320EthicsPlayer.model;

import java.sql.Date;

public class StudentTimesID implements java.io.Serializable {

    private int studentID;
    private int courseID;
    private int scenarioID;
    private int versionID;
    private Date date;
    private int pageID;
    private Date startTime;
    private Date endTime;

    public StudentTimesID(){
        super();
    }

    public StudentTimesID(int sID, int cID, int scenID, int vID, Date date, int pID, Date start, Date end){
        this.studentID=sID;
        this.courseID=cID;
        this.scenarioID=scenID;
        this.versionID=vID;
        this.date=date;
        this.pageID=pID;
        this.startTime=start;
        this.endTime=end;
    }
}