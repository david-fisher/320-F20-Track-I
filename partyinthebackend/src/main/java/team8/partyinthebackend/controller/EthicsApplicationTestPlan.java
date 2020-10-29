package team8.partyinthebackend.controller;
import net.minidev.json.JSONObject;
import org.springframework.web.bind.annotation.*;
import team8.partyinthebackend.model.Student;


import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ZJendex
 * @Time: 10/28/2020, Wed
 **/

@RestController
public class EthicsApplicationTestPlan {
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

    @GetMapping(value = "/students")
    public List<Student> getAllStudents(){
        return Data.students;
    }

    @GetMapping(value = "/students/{student_id}")
    public JSONObject getAllStudents(@PathVariable int student_id){
        try {
            JSONObject obj = new JSONObject();
            obj.put("body", Data.students.get(student_id-1));
            obj.put("status_code", 200);
            return obj;
        }
        catch(Exception e) {
            JSONObject obj = new JSONObject();
            obj.put("status_code", 404);
            return obj;
        }
    }

    @PutMapping(value = "/students/{id}")
    public @ResponseBody Student updateOneStudent(@PathVariable int id, @RequestParam String name){
        Data.students.get(id-1).setName(name);
        return Data.students.get(id-1);
    }
}
