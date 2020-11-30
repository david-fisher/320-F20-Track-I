package com.example.cs320EthicsPlayer.model;

import java.sql.Date;

public class ResponsesID implements java.io.Serializable {

    /**
     * not necessary to include will declare one at runtime, 
     * can create our own too to make warning go away
     */
    private static final long serialVersionUID = 1L;

    int student;
    int course;  
    int scenario;
    int version; 
    Date dateTaken;

    public ResponsesID(){
        super();
    }
    
    public ResponsesID(int studentID, int courseID, int scenarioID, int versionID, Date date_taken){
        this.student=studentID;
        this.course = courseID;
        this.scenario=scenarioID;
        this.version = versionID;
        this.dateTaken=date_taken;
    }
}
