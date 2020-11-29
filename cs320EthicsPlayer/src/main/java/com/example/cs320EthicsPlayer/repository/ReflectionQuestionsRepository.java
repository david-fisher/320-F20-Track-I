package com.example.cs320EthicsPlayer.repository;

import com.example.cs320EthicsPlayer.model.ReflectionQuestions;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReflectionQuestionsRepository extends JpaRepository<ReflectionQuestions, Integer> {
    
}
