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

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;

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
    public Student getOneStudent(@PathVariable Long id){
        try(SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            return mapper.selectById(id);
        }
    }

    //POST
    @PostMapping(value = "/students")
    public List<Student> addOneStudent(){
        try(SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            Student newStudent = new Student();
            newStudent.setId(1);
            newStudent.setName("Jack");
            newStudent.setMajor("cs");
            mapper.create(newStudent);
            return mapper.selectAll();
        }
    }

    //UPDATE
    @PutMapping(value = "/students/{id}")
    public @ResponseBody List<Student> updateOneStudent(@PathVariable Long id, @RequestParam String major, @RequestParam String name){
        try(SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            Student student = mapper.selectById(id);
            student.setMajor("Math");
            //mapper.update(student);
            System.out.println(major + " " + name);
            return mapper.selectAll();
        }
    }

    //DELETE
    @DeleteMapping(value = "/students/{id}")
    //@RequestMapping(value="/delete/{id}", method={RequestMethod.DELETE, RequestMethod.GET})
    public @ResponseBody List<Student> deleteOneStudent(@PathVariable Long id){
        try(SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            mapper.delete(id);
            
            return mapper.selectAll();
        }
    }
}
