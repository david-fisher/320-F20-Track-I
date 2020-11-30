package com.example.cs320EthicsPlayer.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="conversations_had")
@EntityListeners(AuditingEntityListener.class)
public class ConversationsHad {
    
    @Id
    @Column(name="STUDENT")
    int student;

    @Id
    @Column(name="COURSE")
    int course;

    @Id
    @Column(name="Scenario")
    int scenario;

    @Id
    @Column(name="Version")
    int version;

    @Id
    @Column(name="DATE_TAKEN")
    Date date;

    @Column(name="STAKEHOLDER")
    int stakeholder;

    @Column(name="SCORE")
    double score;

    @Column(name="CONVERSATION")
    int convo;

}