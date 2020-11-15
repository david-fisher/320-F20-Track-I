package com.example.cs320EthicsPlayer.repository;

import java.util.List;

import com.example.cs320EthicsPlayer.model.Pages;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PagesRepository extends JpaRepository<Pages,Integer> {
    List<Pages> findByScenarioIDAndScenarioVerID(int scenario, int scenarioVer);
    List<Pages> findByScenarioIDAndScenarioVerIDAndPageType(int scenario, int scenarioVer, String pageType);
}
