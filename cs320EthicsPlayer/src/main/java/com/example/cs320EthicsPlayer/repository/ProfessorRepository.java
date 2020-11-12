package com.example.cs320EthicsPlayer.repository;

import com.example.cs320EthicsPlayer.model.Professor;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Integer> {
    
}
