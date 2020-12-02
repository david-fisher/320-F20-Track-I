package com.example.cs320EthicsPlayer.repository;

import java.sql.Date;
import java.util.List;

import com.example.cs320EthicsPlayer.model.ConversationsHad;
import com.example.cs320EthicsPlayer.model.ConversationsHadID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ConversationsHadRepository extends JpaRepository<ConversationsHad, ConversationsHadID> {
    List<ConversationsHad> findByStudentANDCourseANDScenarioANDVersionANDDate(int student, int course, int scenario, int version, Date date);
}
