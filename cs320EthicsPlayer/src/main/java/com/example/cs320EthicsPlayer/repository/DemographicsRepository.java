package com.example.cs320EthicsPlayer.repository;

import java.util.List;

import com.example.cs320EthicsPlayer.model.Demographics;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DemographicsRepository extends JpaRepository<Demographics, Integer> {
    List<Demographics> findByGrade(String grade);
}
