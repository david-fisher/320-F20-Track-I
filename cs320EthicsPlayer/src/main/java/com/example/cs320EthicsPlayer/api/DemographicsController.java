package com.example.cs320EthicsPlayer.api;

import com.example.cs320EthicsPlayer.repository.DemographicsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class DemographicsController {

    @Autowired
    private DemographicsRepository demographicsRepository;

    public int updateStudentAge(int student_ID, int age){
        return 0;
    }

    public int updateStudentGrade(int student_ID, String grade){
        return 0;
    }

    public int updateStudentGender(int student_ID, String gender){
        return 0;
    }

    public int updateStudentRace(int student_ID, String race){
        return 0;
    }

    public int updateStudentMajor(int student_ID, String major){
        return 0;
    }
}
