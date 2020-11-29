package com.example.cs320EthicsPlayer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.example.cs320EthicsPlayer.repository"})
@ComponentScan(basePackages = { "com.example.cs320EthicsPlayer.model"})
public class Cs320EthicsPlayerApplication {
	public static void main(String[] args) {
		SpringApplication.run(Cs320EthicsPlayerApplication.class, args);
	}

}