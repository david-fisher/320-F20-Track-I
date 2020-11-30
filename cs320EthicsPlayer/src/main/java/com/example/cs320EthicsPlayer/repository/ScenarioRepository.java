package com.example.cs320EthicsPlayer.repository;

import com.example.cs320EthicsPlayer.model.Scenario;
import java.util.List;
import com.example.cs320EthicsPlayer.model.ScenarioID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ScenarioRepository extends JpaRepository<Scenario, ScenarioID> {
    List<Scenario> findByisPublic(boolean isPublic);
}
