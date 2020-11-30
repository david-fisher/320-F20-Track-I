package com.example.cs320EthicsPlayer.repository;

import java.util.List;

import com.example.cs320EthicsPlayer.model.ScenariosFor;
import com.example.cs320EthicsPlayer.model.ScenariosForID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ScenariosForRepository extends JpaRepository<ScenariosFor, ScenariosForID> {
    List<ScenariosFor> findByCourse(int c_ID);
}
