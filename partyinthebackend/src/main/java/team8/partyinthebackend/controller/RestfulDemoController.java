package team8.partyinthebackend.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.web.bind.annotation.*;
import team8.partyinthebackend.model.Student;
import team8.partyinthebackend.utils.MybatisUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ZJendex
 * @Time: 9/30/2020, Wed
 **/

@RestController
public class RestfulDemoController {
    public static class Data {
        public static List<Student> students = new ArrayList<>(){
            {
                add(new Student(1, "Keven"));
                add(new Student(2, "Lily"));
                add(new Student(3, "Jack"));
                add(new Student(4, "Cindy"));
                add(new Student(5, "Peter"));
            }
        };
    }

    //GET
    @GetMapping(value = "/students")
    public List<Student> getAllStudents(){
        return Data.students;
    }

    //GET
    @GetMapping(value = "/students/{id}")
    public Student getOneStudent(@PathVariable int id){
        return Data.students.get(id-1);
    }

//    //POST
//    @PostMapping(value = "/students")
//    public List<Student> addOneStudent(){
//        return null;
//    }

    //UPDATE
    @PutMapping(value = "/students/{id}")
    public @ResponseBody Student updateOneStudent(@PathVariable int id, @RequestParam String name){
        Data.students.get(id-1).setName(name);
        return Data.students.get(id-1);
    }

//    //DELETE
//    @DeleteMapping(value = "/students/{id}")
//    public @ResponseBody List<Student> deleteOneStudent(@PathVariable Long id){
//        return null;
//    }
}
