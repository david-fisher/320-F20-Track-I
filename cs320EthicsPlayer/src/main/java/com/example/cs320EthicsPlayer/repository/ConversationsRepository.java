package com.example.cs320EthicsPlayer.repository;

import com.example.cs320EthicsPlayer.model.Conversations;
import com.example.cs320EthicsPlayer.model.ConversationsHad;
import com.example.cs320EthicsPlayer.model.ConversationsID;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ConversationsRepository extends JpaRepository<Conversations, ConversationsID> {
    List<Conversations> findByStakeholder(int stakeholder_id);

}
