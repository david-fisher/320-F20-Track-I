package team8.partyinthebackend.model;

/**
 * @Author: ZJendex
 * @Time: 9/30/2020, Wed
 **/


public class Student {

    private int id;
    private String name;
    private Courses courses;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        this.courses = new Courses();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Courses getCourses() {
        return courses;
    }

    public void addCourse(int id, String name) {
        //this.courses.addScenario(id, name);
    }
}

