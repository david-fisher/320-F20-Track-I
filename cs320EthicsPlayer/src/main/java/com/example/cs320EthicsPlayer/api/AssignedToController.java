package com.example.cs320EthicsPlayer.api;

import java.util.List;

import com.example.cs320EthicsPlayer.model.AssignedTo;
import com.example.cs320EthicsPlayer.model.AssignedToID;
import com.example.cs320EthicsPlayer.model.Student;
import com.example.cs320EthicsPlayer.repository.StudentRepository;
import com.example.cs320EthicsPlayer.repository.AssignedToRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class AssignedToController {
    
    @Autowired
    private AssignedToRepository assignedToRepository;

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/getScenariosAssignedToStudent/{student_id}")
    public List<AssignedTo> getScenariosAssignedToStudent(@PathVariable(value = "student_id") int student_id) throws Exception {
        List<AssignedTo> scenariosForStudent = assignedToRepository.findByStudentID(student_id);
        return scenariosForStudent;
    }
}
