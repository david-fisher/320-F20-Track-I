package team8.partyinthebackend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import team8.partyinthebackend.model.Student;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: ZJendex
 * @Time: 9/30/2020, Wed
 **/

@RestController
public class RestfulDemoController {
    private static Map<String, Student> studentRepo = new HashMap<>();
    static {
        Student Jack = new Student();
        Jack.setId("1");
        Jack.setName("Jack");
        studentRepo.put(Jack.getId(), Jack);

        Student Fiona = new Student();
        Fiona.setId("2");
        Fiona.setName("Fiona");
        studentRepo.put(Fiona.getId(), Fiona);
    }

    //GET
    @RequestMapping(value = "/students")
    public ResponseEntity<Object> getStudent() {
        return new ResponseEntity<>(studentRepo.values(), HttpStatus.OK);
    }

    //POST
    @PostMapping(value = "/students")
    public ResponseEntity<Object> createStudent(@RequestBody Student student) {
        studentRepo.put(student.getId(), student);
        return new ResponseEntity<>("Student is created successfully", HttpStatus.CREATED);
    }

    //PUT
    @RequestMapping(value = "/students/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateStudent(@PathVariable("id") String id, @RequestBody Student student) {
        studentRepo.remove(id);
        student.setId(id);
        studentRepo.put(id, student);
        return new ResponseEntity<>("Student is updated successfully", HttpStatus.OK);
    }

    //DELETE
    @RequestMapping(value = "/students/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable("id") String id) {
        studentRepo.remove(id);
        return new ResponseEntity<>("Student is deleted successfully", HttpStatus.OK);
    }

}
