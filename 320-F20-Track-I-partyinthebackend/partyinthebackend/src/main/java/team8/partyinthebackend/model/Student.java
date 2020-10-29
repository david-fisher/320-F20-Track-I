package team8.partyinthebackend.model;

import javax.persistence.*;

/**
 * @Author: ZJendex
 * @Time: 9/30/2020, Wed
 **/

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String major;

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

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String toString() {
        return Long.toString(this.id) + " " + this.name + " " + this.major;
    }
}
