package team8.partyinthebackend.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import team8.partyinthebackend.mapper.StudentMapper;
import team8.partyinthebackend.model.Student;
import team8.partyinthebackend.utils.MybatisUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: ZJendex
 * @Time: 9/30/2020, Wed
 **/

@RestController
public class RestfulDemoController {
    //GET
    @GetMapping(value = "/students")
    public List<Student> getAllStudents(){
        try(SqlSession sqlSession = MybatisUtils.getSqlSession()) {

            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

            return mapper.selectAll();
        }
    }

    //GET
    @GetMapping(value = "/students/{id}")
    public List<Student> getOneStudent(@PathVariable Long id){
        try(SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            return mapper.selectById(id);
        }
    }

    //POST
    @GetMapping(value = "/addone")
    public List<Student> addOneStudent(){
        try(SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            Student newStudent = new Student();
            newStudent.setId(5);
            newStudent.setName("Andy");
            newStudent.setMajor("cs");
            mapper.create(newStudent);
            return mapper.selectAll();
        }
    }

    //UPDATE
    @GetMapping(value = "/update")
    public List<Student> updateOneStudent(){
        try(SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            Student updatedStudent = new Student();
            updatedStudent.setName("Tim");
            updatedStudent.setMajor("math");
            updatedStudent.setId(2);
            mapper.update(updatedStudent);
            return mapper.selectAll();
        }
    }

    //DELETE
    @GetMapping(value = "/delete/{id}")
    public List<Student> deleteOneStudent(@PathVariable Long id){
        try(SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            mapper.delete(id);
            return mapper.selectAll();
        }
    }


}
