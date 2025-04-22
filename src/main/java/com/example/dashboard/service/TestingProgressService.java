package com.example.dashboard.service;

import com.example.dashboard.entity.TestingProgressData;
import com.example.dashboard.entity.TestingTeamData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TestingProgressService {
    public TestingProgressData getTestingProgressData() {
        List<TestingTeamData> teams = new ArrayList<>();
        
        // 团队A
        teams.add(new TestingTeamData("团队A", 70, 30, 100, 80, 20));
        
        // 团队B
        teams.add(new TestingTeamData("团队B", 60, 40, 90, 70, 20));
        
        // 团队C
        teams.add(new TestingTeamData("团队C", 80, 20, 110, 90, 20));
        
        // 团队D
        teams.add(new TestingTeamData("团队D", 65, 35, 95, 75, 20));
        
        // 团队E
        teams.add(new TestingTeamData("团队E", 75, 25, 105, 85, 20));
        
        // 团队F
        teams.add(new TestingTeamData("团队F", 55, 45, 85, 65, 20));
        
        // 团队G
        teams.add(new TestingTeamData("团队G", 85, 15, 115, 95, 20));
        
        // 团队H
        teams.add(new TestingTeamData("团队H", 70, 30, 100, 80, 20));
        
        // 团队I
        teams.add(new TestingTeamData("团队I", 60, 40, 90, 70, 20));
        
        // 团队J
        teams.add(new TestingTeamData("团队J", 80, 20, 110, 90, 20));

        return new TestingProgressData(teams);
    }
} 