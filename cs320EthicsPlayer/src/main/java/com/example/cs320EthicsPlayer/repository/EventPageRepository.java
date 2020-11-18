package com.example.cs320EthicsPlayer.repository;

import java.util.List;

//import java.util.List;

import com.example.cs320EthicsPlayer.model.EventPage;
import com.example.cs320EthicsPlayer.model.EventPageID;
//import com.example.cs320EthicsPlayer.model.Pages;

import org.springframework.data.jpa.repository.JpaRepository;


public interface EventPageRepository extends JpaRepository<EventPage, EventPageID> {
    List<EventPage> findByPageID(int pID);

}
