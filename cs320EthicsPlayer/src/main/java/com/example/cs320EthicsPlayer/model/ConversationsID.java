package com.example.cs320EthicsPlayer.model;

public class ConversationsID implements java.io.Serializable {
    
    int stakeholder;
    int convo;

    public ConversationsID(){
        super();
    }

    public ConversationsID(int stakeholder, int convo){
        this.stakeholder=stakeholder;
        this.convo=convo;
    }
}

