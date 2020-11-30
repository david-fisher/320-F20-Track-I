package com.example.cs320EthicsPlayer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="professors")
@EntityListeners(AuditingEntityListener.class)
public class Professor {
    
    @Id
    @Column(name="PROFESSOR", nullable = false)
    private int id;

    @Column(name="Name", nullable = false)
    private String name;

    public Professor(){
        super();
    }

    public Professor(@JsonProperty("professor")int id,@JsonProperty("name") String name){
        this.id=id;
        this.name=name;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public void setId(int id){
        this.id=id;
    }

    public void setName(String name){
        this.name=name;
    }
}
