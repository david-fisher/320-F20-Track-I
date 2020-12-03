package com.example.cs320EthicsPlayer.model;

import java.sql.Date;

public class ConversationsHadID implements java.io.Serializable {
    
    int student;
    int course;
    int scenario;
    int version;
    Date date;

    public ConversationsHadID(){
        super();
    }

    public ConversationsHadID(int student, int course, int scenario, int version, Date date){
        this.student=student;
        this.course=course;
        this.scenario=scenario;
        this.version=version;
        this.date=date;
    }

}
