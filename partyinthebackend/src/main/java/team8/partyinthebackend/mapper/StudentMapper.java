package team8.partyinthebackend.mapper;

import java.util.List;

import team8.partyinthebackend.model.Student;

public interface StudentMapper {
    //select all students
    public List<Student> selectAll();

    // Select students by ID.
    public Student selectById(long id);

    // Student account creation(?)
    public void create(Student student);

    // Update student details.
    public void update(Student student);

    // Remove a student by ID.
    public void delete(long id);


}
