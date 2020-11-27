package com.example.cs320EthicsPlayer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="stakeholders")
@EntityListeners(AuditingEntityListener.class)
public class Stakeholders {

    @Id
    @Column(name="STAKEHOLDER")
    int stakeholder_ID;

    @Column(name="NAME")
    String name;

    @Column(name="DESCRIPTION")
    String description;

    @Column(name="JOB")
    String job;

    @Column(name="Scenario")
    int scenario;

    @Column(name="Version")
    int scenarioVer;

    @Column(name="INTRODUCTION")
    String introduction;

    public Stakeholders(){
        super();
    }

    public Stakeholders(@JsonProperty("STAKEHOLDER") int stakeholder_ID, @JsonProperty("NAME") String name, @JsonProperty("DESCRIPTION") String description, @JsonProperty("JOB") String job, @JsonProperty("Scenario") int scenario, @JsonProperty("Version") int scenarioVer, @JsonProperty("INTRODUCTION") String introduction){
        this.stakeholder_ID=stakeholder_ID;
        this.name=name;
        this.description=description;
        this.job=job;
        this.scenario=scenario;
        this.scenarioVer=scenarioVer;
        this.introduction=introduction;
    }

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getJob() {
		return job;
	}
	
	public String getIntroduction() {
		return introduction;
	}
}
