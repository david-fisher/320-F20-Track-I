package team8.partyinthebackend.model;

import javax.persistence.*;

public class Stakeholder {

    private long id;
    private String name;
    private String title;
    private String description;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String toString() {
        return Long.toString(this.id) + " " + this.name + " " + this.title;
    }
}
