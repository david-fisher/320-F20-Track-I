package com.example.cs320EthicsPlayer.model;

import java.sql.Date;

public class ReflectionsID implements java.io.Serializable {

    /**
     * not necessary to include will declare one at runtime, 
     * can create our own too to make warning go away
     */
    private static final long serialVersionUID = 4L;

    private String reflections;
    private int sID;
    private int cID;
    private int scenario;
    private int version;
    private Date date;  

    public ReflectionsID(){
        super();
    }
    
    public ReflectionsID(String reflections, int s_ID, int c_ID, int scenario, int e_ID, Date date){
        this.reflections=reflections;
        this.sID=s_ID;
        this.cID=c_ID;
        this.scenario=
        this.version=e_ID; 
        this.date=date;
    }
}
