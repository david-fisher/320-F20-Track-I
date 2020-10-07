package team8.partyinthebackend.mapper;

import java.util.List;

import team8.partyinthebackend.model.Student;

public interface StudentMapper {
    //select all students
    List<Student> selectAll();

    List<Student> selectById(long id);

    void create(Student student);

    void update(Student t);

    void delete(long id);


}
