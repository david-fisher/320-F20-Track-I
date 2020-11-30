package com.example.cs320EthicsPlayer.repository;

import java.util.List;

import com.example.cs320EthicsPlayer.model.AssignedTo;
import com.example.cs320EthicsPlayer.model.AssignedToID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AssignedToRepository extends JpaRepository<AssignedTo, AssignedToID> {
    List<AssignedTo> findByStudentID(int student_ID);
    List<AssignedTo> findByScenarioID(int scenario_ID);
    List<AssignedTo> findByVersionID(int version_ID);
}
