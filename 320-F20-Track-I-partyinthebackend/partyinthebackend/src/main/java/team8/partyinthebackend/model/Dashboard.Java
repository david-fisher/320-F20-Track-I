package team8.partyinthebackend.model;

import javax.persistence.*;

//Author: Vincent Tran

@Entity
public class Dashboard{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int version;
    private String body;
    
    //Constructor for page with no initial answer/page that won't need an answer
    public Dashboard(long i, int v, String str){
        this.id = i;
        this.version = v;
        this.body = str;
        this.sAnswer = "";
    }

    //Get ID
    public long getID(){
        return this.id;
    }

    //Get Version
    public int getVersion(){
        return this.version;
    }

    //Get Body Text
    public String getBody(){
        return this.body;
    }

    //I'm going to omit the setID and setBody method because I don't think anyone will be changing the ID of a page or the contents once retreived from the database

    //Set version
    public void setVersion(int v){
        this.version = v;
    }

}