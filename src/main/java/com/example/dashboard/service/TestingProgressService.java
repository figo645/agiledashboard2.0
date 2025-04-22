package com.example.dashboard.service;

import com.example.dashboard.entity.TestingProgressData;
import com.example.dashboard.entity.TeamTestingData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TestingProgressService {
    
    public TestingProgressData getTestingProgressData() {
        List<TeamTestingData> teams = new ArrayList<>();
        teams.add(new TeamTestingData("团队A", 100, 80, 20, 15, 5));
        teams.add(new TeamTestingData("团队B", 120, 90, 30, 20, 10));
        teams.add(new TeamTestingData("团队C", 150, 120, 30, 25, 5));
        teams.add(new TeamTestingData("团队D", 130, 100, 30, 20, 10));
        teams.add(new TeamTestingData("团队E", 140, 110, 30, 25, 5));
        return new TestingProgressData(teams);
    }
} 