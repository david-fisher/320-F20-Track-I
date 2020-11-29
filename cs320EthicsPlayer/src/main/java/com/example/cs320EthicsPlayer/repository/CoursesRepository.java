package com.example.cs320EthicsPlayer.repository;

import com.example.cs320EthicsPlayer.model.Courses;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursesRepository extends JpaRepository<Courses, Integer> {
    
}
