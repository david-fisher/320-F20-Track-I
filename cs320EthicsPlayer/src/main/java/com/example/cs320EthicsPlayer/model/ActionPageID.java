package com.example.cs320EthicsPlayer.model;

public class ActionPageID implements java.io.Serializable {
    
    private static final long serialVersionUID = 3L;

    private int pageID;
    private String choice;
    private int resultPage;

    public ActionPageID(){
        super();
    }

    public ActionPageID(int page_ID, String choice, int result_page){
        this.pageID=page_ID;
        this.choice = choice;
        this.resultPage = result_page;
    }
}
