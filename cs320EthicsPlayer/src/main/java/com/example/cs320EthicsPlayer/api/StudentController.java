package com.example.cs320EthicsPlayer.api;

import java.util.List;

import com.example.cs320EthicsPlayer.model.Student;
import com.example.cs320EthicsPlayer.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable(value = "id") int studentId) throws Exception {

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new Exception("Student " + studentId + " not found"));
        return ResponseEntity.ok().body(student);
    }

    @GetMapping("/studentsName/{id}")
    public String getStudentName(@PathVariable(value = "id") int studentId) throws Exception {

      Student student = studentRepository.findById(studentId)
              .orElseThrow(() -> new Exception("Student " + studentId + " not found"));
      return student.getName();
  }

    @PostMapping("/students") // POST Method for Create operation
    public int newStudent(@RequestBody Student student) throws Exception {
      if(student.getName().length()>70){
        throw new Exception("Name length too long");
      }
      studentRepository.save(student);
      return student.getId();
    }

    @PutMapping("/students/{id}")    // PUT Method for Update operation
    public ResponseEntity<Student> updateStudent(@PathVariable(value = "id") int studentId, @Validated @RequestBody Student studentDetails)
        throws Exception {
      if(studentDetails.getName().length()>70){
          throw new Exception("Name length too long");
        }
      Student student = studentRepository.findById(studentId)
                  .orElseThrow(() -> new Exception("Student " + studentId + " not found"));
  
      student.setName(studentDetails.getName());
      student.setId(studentDetails.getId());
  
      final Student updatedStudent = studentRepository.save(student);
      return ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping("/students/{id}")    // DELETE Method for Delete operation
    public int deleteStudent(@PathVariable(value = "id") int studentId) throws Exception {
      Student student = studentRepository.findById(studentId)
                  .orElseThrow(() -> new Exception("Student " + studentId + " not found"));
  
      studentRepository.delete(student);
      return 1;
    }    
}
