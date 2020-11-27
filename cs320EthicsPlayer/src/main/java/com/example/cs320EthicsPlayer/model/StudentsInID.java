package com.example.cs320EthicsPlayer.model;

public class StudentsInID implements java.io.Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 2L;

    int studentID;
    int courseID;
    
    public StudentsInID(){
        super();
    }

    public StudentsInID(int student_ID, int course_ID){
        this.studentID=student_ID;
        this.courseID=course_ID;
    }
}
