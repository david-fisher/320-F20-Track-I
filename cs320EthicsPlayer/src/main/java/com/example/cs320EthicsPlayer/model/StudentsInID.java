package com.example.cs320EthicsPlayer.model;

public class StudentsInID implements java.io.Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 2L;

    int student_ID;
    int course_ID;
    
    public StudentsInID(){
        super();
    }

    public StudentsInID(int student_ID, int course_ID){
        this.student_ID=student_ID;
        this.course_ID=course_ID;
    }
}
