package com.example.cs320EthicsPlayer.repository;

import java.util.List;

import com.example.cs320EthicsPlayer.model.Pages;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PagesRepository extends JpaRepository<Pages,Integer> {
    List<Integer> findByScenarioIDAndScenarioVerID(int scenario, int scenarioVer);
    List<Integer> findByScenarioIDAndScenarioVerIDAndPageType(int scenario, int scenarioVer, String pageType);
}
