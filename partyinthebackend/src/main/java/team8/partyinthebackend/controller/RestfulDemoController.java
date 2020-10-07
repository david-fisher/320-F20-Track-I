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
    @PostMapping(value = "/students", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addOneStudent(@RequestBody Student student){
        try(SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            mapper.create(student);
        }
    }

//    //PUT
//    @RequestMapping(value = "/students/{id}", method = RequestMethod.PUT)
//
//
//    //DELETE
//    @RequestMapping(value = "/students/{id}", method = RequestMethod.DELETE)


}
