package com.example.cs320EthicsPlayer.repository;

import com.example.cs320EthicsPlayer.model.Responses;
import java.util.List;
import com.example.cs320EthicsPlayer.model.ResponsesID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ResponsesRepository extends JpaRepository<Responses, ResponsesID> {
    List<Responses> findByStudent(int studentID);
}
