package com.example.cs320EthicsPlayer.model;

public class EventPageID implements java.io.Serializable {
    
    private static final long serialVersionUID = 3L;

    private int pageID;
    private String pageInfo;

    public EventPageID(){
        super();
    }

    public EventPageID(int page_ID, String pageInfo){
        this.pageID=page_ID;
        this.pageInfo=pageInfo;
    }
}
