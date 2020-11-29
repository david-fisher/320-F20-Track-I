package com.example.cs320EthicsPlayer.repository;

import java.util.List;

//import java.util.List;

import com.example.cs320EthicsPlayer.model.ActionPage;
import com.example.cs320EthicsPlayer.model.ActionPageID;
//import com.example.cs320EthicsPlayer.model.Pages;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ActionPageRepository extends JpaRepository<ActionPage, ActionPageID> {
    List<ActionPage> findByPageID(int pID);

}
