package com.example.dashboard.service;

import com.example.dashboard.model.SprintPlanningData;
import com.example.dashboard.model.TeamData;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class SprintPlanningService {
    
    public SprintPlanningData getSprintPlanningData() {
        List<TeamData> teams = Arrays.asList(
            new TeamData("团队A", 10, 100, 10, 60, 20, 10, 10, 30, 5, 2),
            new TeamData("团队B", 8, 80, 10, 50, 30, 10, 10, 25, 3, 1),
            new TeamData("团队C", 12, 120, 10, 70, 15, 5, 10, 35, 4, 3),
            new TeamData("团队D", 9, 90, 10, 55, 25, 10, 10, 28, 4, 2),
            new TeamData("团队E", 11, 110, 10, 65, 20, 5, 10, 32, 3, 2)
        );
        
        return new SprintPlanningData(teams);
    }
} 