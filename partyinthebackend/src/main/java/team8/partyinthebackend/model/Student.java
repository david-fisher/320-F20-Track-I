package team8.partyinthebackend.model;

/**
 * @Author: ZJendex
 * @Time: 9/30/2020, Wed
 **/


public class Student {

    private int id;
    private String name;
    private int[] scenariosAssignedToStudent;
    private int[] coursesInStudent;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        this.scenariosAssignedToStudent = new int[]{1, 2, 3};
        this.coursesInStudent = new int[]{1, 2, 3};
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

    public int[] getCoursesInStudent() {
        return coursesInStudent;
    }

    public void setCoursesInStudent(int[] coursesInStudent) {
        this.coursesInStudent = coursesInStudent;
    }

    public int[] getScenariosAssignedToStudent() {
        return scenariosAssignedToStudent;
    }

    public void setScenariosAssignedToStudent(int[] scenariosAssignedToStudent) {
        this.scenariosAssignedToStudent = scenariosAssignedToStudent;
    }
}

