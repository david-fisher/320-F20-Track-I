package com.example.cs320EthicsPlayer.repository;

import java.util.List;

import com.example.cs320EthicsPlayer.model.StudentsIn;
import com.example.cs320EthicsPlayer.model.StudentsInID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentsInRepository extends JpaRepository<StudentsIn, StudentsInID> {
    List<Integer> findBycourseID(int c_ID);
    List<Integer> findBystudentID(int s_ID);
}
