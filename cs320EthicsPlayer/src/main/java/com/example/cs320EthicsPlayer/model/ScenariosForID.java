package com.example.cs320EthicsPlayer.model;

public class ScenariosForID implements java.io.Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 2L;

    int scenario;
    int version;
    int course;
    
    public ScenariosForID(){
        super();
    }

    public ScenariosForID(int scenarioID, int versionID, int courseID){
        this.scenario=scenarioID;
        this.version=versionID;
        this.course = courseID;
    }
}
