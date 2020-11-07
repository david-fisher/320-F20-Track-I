package com.example.cs320EthicsPlayer.repository;

//import java.util.List;

import com.example.cs320EthicsPlayer.model.EventPage;
//import com.example.cs320EthicsPlayer.model.EventPageID;
//if body is primary id replace integer with EventPageID

import org.springframework.data.jpa.repository.JpaRepository;


public interface EventPageRepository extends JpaRepository<EventPage, Integer> {
    //List<String> findByPageID(int s_ID);
}
