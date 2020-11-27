package com.example.cs320EthicsPlayer.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.cs320EthicsPlayer.model.Professor;
import com.example.cs320EthicsPlayer.repository.ProfessorRepository;

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
public class ProfessorController {

    @Autowired
    private ProfessorRepository professorRepository;

    @GetMapping("/professors")
    public List<Professor> getAllProfessors() {
        return professorRepository.findAll();
    }

    @GetMapping("/professors/{id}")
    public ResponseEntity<Professor> getProfessorById(@PathVariable(value = "id") int professorId) throws Exception {

        Professor professor = professorRepository.findById(professorId)
                .orElseThrow(() -> new Exception("Professor " + professorId + " not found"));
        return ResponseEntity.ok().body(professor);
    }

    @PostMapping("/professors") // POST Method for Create operation
    public Professor newProfessor(@Validated @RequestBody Professor professor) {
      return professorRepository.save(professor);
    }

    @PutMapping("/professors/{id}")    // PUT Method for Update operation
    public ResponseEntity<Professor> updateProfessor(
        @PathVariable(value = "id") int professorId, @Validated @RequestBody Professor professorDetails)
        throws Exception {
  
      Professor professor = professorRepository.findById(professorId)
                  .orElseThrow(() -> new Exception("Professor " + professorId + " not found"));
  
      professor.setName(professorDetails.getName());
      professor.setId(professorDetails.getId());
  
      final Professor updatedProfessor = professorRepository.save(professor);
      return ResponseEntity.ok(updatedProfessor);
    }

    @DeleteMapping("/professors/{id}")    // DELETE Method for Delete operation
    public Map<String, Boolean> deleteProfessor(@PathVariable(value = "id") int professorId) throws Exception {
      Professor professor = professorRepository.findById(professorId)
                  .orElseThrow(() -> new Exception("Professor " + professorId + " not found"));
  
      professorRepository.delete(professor);
      Map<String, Boolean> response = new HashMap<>();
      response.put("deleted", Boolean.TRUE);
      return response;
    }    
}
