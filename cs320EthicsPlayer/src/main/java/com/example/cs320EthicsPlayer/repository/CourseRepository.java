package com.example.cs320EthicsPlayer.repository;

import com.example.cs320EthicsPlayer.model.Demographics;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Demographics, Integer> {
    
}
