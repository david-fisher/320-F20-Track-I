package team8.partyinthebackend.mapper;

import java.util.List;

import team8.partyinthebackend.model.Student;

public interface StudentMapper {
    //select all students
    public List<Student> selectAll();

    public List<Student> selectById(long id);

    public void create(Student student);

    public void update(Student t);

    public void delete(long id);


}
