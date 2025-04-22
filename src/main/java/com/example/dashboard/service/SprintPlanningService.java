package com.example.dashboard.service;

import com.example.dashboard.entity.SprintPlanningData;
import com.example.dashboard.entity.TeamData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SprintPlanningService {
    public SprintPlanningData getSprintPlanningData() {
        List<TeamData> teams = new ArrayList<>();
        
        // 团队A
        teams.add(new TeamData(
            "团队A", 10, 100, 10.0,
            60, 20, 10, 10,
            30, 5, 2
        ));
        
        // 团队B
        teams.add(new TeamData(
            "团队B", 8, 80, 10.0,
            50, 30, 10, 10,
            25, 3, 1
        ));
        
        // 团队C
        teams.add(new TeamData(
            "团队C", 12, 120, 10.0,
            70, 15, 5, 10,
            35, 4, 3
        ));
        
        // 团队D
        teams.add(new TeamData(
            "团队D", 9, 90, 10.0,
            55, 25, 10, 10,
            28, 4, 2
        ));
        
        // 团队E
        teams.add(new TeamData(
            "团队E", 11, 110, 10.0,
            65, 20, 5, 10,
            32, 3, 2
        ));
        
        // 团队F
        teams.add(new TeamData(
            "团队F", 7, 70, 10.0,
            45, 35, 10, 10,
            22, 2, 1
        ));
        
        // 团队G
        teams.add(new TeamData(
            "团队G", 13, 130, 10.0,
            75, 15, 5, 5,
            38, 5, 3
        ));
        
        // 团队H
        teams.add(new TeamData(
            "团队H", 10, 100, 10.0,
            60, 20, 10, 10,
            30, 4, 2
        ));
        
        // 团队I
        teams.add(new TeamData(
            "团队I", 8, 80, 10.0,
            50, 30, 10, 10,
            25, 3, 1
        ));
        
        // 团队J
        teams.add(new TeamData(
            "团队J", 12, 120, 10.0,
            70, 15, 5, 10,
            35, 4, 3
        ));

        return new SprintPlanningData(teams);
    }
} 