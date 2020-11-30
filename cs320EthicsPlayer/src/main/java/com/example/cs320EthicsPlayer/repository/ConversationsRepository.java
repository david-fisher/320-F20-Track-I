package com.example.cs320EthicsPlayer.repository;

import com.example.cs320EthicsPlayer.model.Conversations;
import com.example.cs320EthicsPlayer.model.ConversationsID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ConversationsRepository extends JpaRepository<Conversations, ConversationsID> {
    
}
