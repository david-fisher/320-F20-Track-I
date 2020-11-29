package com.example.cs320EthicsPlayer.repository;

import com.example.cs320EthicsPlayer.model.Student;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    
}
