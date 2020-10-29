package team8.partyinthebackend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import team8.partyinthebackend.mapper.StudentMapper;
import team8.partyinthebackend.model.Student;
import team8.partyinthebackend.utils.MybatisUtils;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class HelloWorldController {

    @RequestMapping("/")
    public String index(){
        return "Hello World";
    }

    @RequestMapping("/home")
    public String home(){
        return "Homepage";
    }

    @GetMapping("/test")
    public String test() {
        try(SqlSession sqlSession = MybatisUtils.getSqlSession()) {

            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            
            List<Student> students = mapper.selectAll();
            String firstStudentInfo = students.get(0).toString();
            return "{\"success\":\"" + firstStudentInfo + "\"}";
        }
    }
    
    @RequestMapping("/student")
    public List<Student> getAllStudents(){
        try(SqlSession sqlSession = MybatisUtils.getSqlSession()) {

            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            
            return mapper.selectAll();
        }

    }
    
}