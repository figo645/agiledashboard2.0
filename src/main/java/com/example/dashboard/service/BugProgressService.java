package com.example.dashboard.service;

import com.example.dashboard.entity.BugProgressData;
import com.example.dashboard.entity.TeamBugData;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class BugProgressService {
    
    public BugProgressData getBugProgressData() {
        List<TeamBugData> teams = Arrays.asList(
            new TeamBugData("团队A", 5, 3, 2, 4, 2, 2),
            new TeamBugData("团队B", 8, 5, 3, 6, 3, 3),
            new TeamBugData("团队C", 12, 8, 4, 9, 4, 4),
            new TeamBugData("团队D", 15, 10, 5, 12, 5, 5),
            new TeamBugData("团队E", 10, 7, 3, 8, 3, 3)
        );
        return new BugProgressData(teams);
    }
} 