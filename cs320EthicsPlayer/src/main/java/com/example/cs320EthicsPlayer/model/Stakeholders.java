package com.example.cs320EthicsPlayer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="stakeholders")
@EntityListeners(AuditingEntityListener.class)
public class Stakeholders {

    @Id
    @Column(name="STK_ID")
    int stakeholder_ID;

    @Column(name="NAME")
    String name;

    @Column(name="DESCRIPTION")
    String description;

    @Column(name="JOB")
    String job;

    @Column(name="Scenario")
    int scenario;

    @Column(name="ScenarioVer")
    int scenarioVer;

    public Stakeholders(){
        super();
    }

    public Stakeholders(int stakeholder_ID, String name, String description, String job, int scenario, int scenarioVer){
        this.stakeholder_ID=stakeholder_ID;
        this.name=name;
        this.description=description;
        this.job=job;
        this.scenario=scenario;
        this.scenarioVer=scenarioVer;
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
}
