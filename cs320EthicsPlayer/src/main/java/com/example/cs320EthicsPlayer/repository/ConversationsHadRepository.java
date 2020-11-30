package com.example.cs320EthicsPlayer.repository;

import com.example.cs320EthicsPlayer.model.ConversationsHad;
import com.example.cs320EthicsPlayer.model.ConversationsHadID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ConversationsHadRepository extends JpaRepository<ConversationsHad, ConversationsHadID> {
    
}
