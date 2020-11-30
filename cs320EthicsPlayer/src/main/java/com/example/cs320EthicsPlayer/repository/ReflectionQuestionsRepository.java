package com.example.cs320EthicsPlayer.repository;

import com.example.cs320EthicsPlayer.model.EventPage;
import com.example.cs320EthicsPlayer.model.ReflectionQuestions;
import com.example.cs320EthicsPlayer.model.ReflectionQuestionsID;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReflectionQuestionsRepository extends JpaRepository<ReflectionQuestions, ReflectionQuestionsID> {
    List<ReflectionQuestions> findByPageID(int pID);

}
