package com.example.cs320EthicsPlayer.model;

public class ReflectionQuestionsID implements java.io.Serializable {
    private int pageID;
    private String reflectionQ;

    public ReflectionQuestionsID(){
        super();
    }

    public ReflectionQuestionsID(int pageID, String reflectionQ){
        this.pageID=pageID;
        this.reflectionQ=reflectionQ;
    }
}
