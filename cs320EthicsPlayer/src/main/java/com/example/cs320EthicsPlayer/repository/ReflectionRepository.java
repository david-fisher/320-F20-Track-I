package com.example.cs320EthicsPlayer.repository;

import com.example.cs320EthicsPlayer.model.Reflections;
import com.example.cs320EthicsPlayer.model.ReflectionsID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReflectionRepository extends JpaRepository<Reflections, ReflectionsID> {
    
}