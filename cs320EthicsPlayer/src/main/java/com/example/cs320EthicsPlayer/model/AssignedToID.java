package com.example.cs320EthicsPlayer.model;

public class AssignedToID implements java.io.Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 2L;

    int studentID;
    int scenarioID;
    int versionID;
    
    public AssignedToID(){
        super();
    }

    public AssignedToID(int student_ID, int scenario_ID, int version_ID){
        this.studentID=student_ID;
        this.scenarioID=scenario_ID;
        this.versionID=version_ID;
    }
}
