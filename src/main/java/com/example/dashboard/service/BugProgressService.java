package com.example.dashboard.service;

import com.example.dashboard.entity.BugProgressData;
import com.example.dashboard.entity.BugTeamData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BugProgressService {
    public BugProgressData getBugProgressData() {
        List<BugTeamData> teams = new ArrayList<>();
        
        // 团队A
        teams.add(new BugTeamData("团队A", 5, 10, 3, 7, 2, 3, 1));
        
        // 团队B
        teams.add(new BugTeamData("团队B", 3, 8, 2, 5, 1, 2, 1));
        
        // 团队C
        teams.add(new BugTeamData("团队C", 4, 12, 3, 8, 2, 3, 1));
        
        // 团队D
        teams.add(new BugTeamData("团队D", 4, 11, 2, 6, 1, 2, 1));
        
        // 团队E
        teams.add(new BugTeamData("团队E", 3, 9, 2, 6, 1, 2, 1));
        
        // 团队F
        teams.add(new BugTeamData("团队F", 2, 7, 1, 4, 1, 1, 1));
        
        // 团队G
        teams.add(new BugTeamData("团队G", 5, 13, 3, 9, 2, 3, 1));
        
        // 团队H
        teams.add(new BugTeamData("团队H", 4, 10, 2, 7, 1, 2, 1));
        
        // 团队I
        teams.add(new BugTeamData("团队I", 3, 8, 2, 5, 1, 2, 1));
        
        // 团队J
        teams.add(new BugTeamData("团队J", 4, 12, 3, 8, 2, 3, 1));

        return new BugProgressData(teams);
    }
} 