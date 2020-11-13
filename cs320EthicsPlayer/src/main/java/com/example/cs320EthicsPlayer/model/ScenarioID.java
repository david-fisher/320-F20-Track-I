package com.example.cs320EthicsPlayer.model;

public class ScenarioID implements java.io.Serializable {

    /**
     * not necessary to include will declare one at runtime, 
     * can create our own too to make warning go away
     */
    private static final long serialVersionUID = 1L;

    int scenario;
    int version;   

    public ScenarioID(){
        super();
    }
    
    public ScenarioID(int EID, int VERSIONID){
        this.scenario=EID;
        this.version = VERSIONID;
    }
}
