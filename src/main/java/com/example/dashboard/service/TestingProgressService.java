package com.example.dashboard.service;

import com.example.dashboard.model.TestingProgressData;
import com.example.dashboard.model.TeamTestingProgress;
import com.example.dashboard.model.TestCaseStats;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class TestingProgressService {
    
    public TestingProgressData getTestingProgressData() {
        List<String> labels = Arrays.asList("第1周", "第2周", "第3周", "第4周");
        List<Integer> plannedTesting = Arrays.asList(30, 60, 90, 100);
        List<Integer> actualTesting = Arrays.asList(25, 55, 80, 95);
        
        TestCaseStats totalStats = new TestCaseStats(200, 180, 175, 5);
        
        List<TeamTestingProgress> teams = Arrays.asList(
            new TeamTestingProgress(
                "团队A",
                Arrays.asList(20, 50, 75, 90),
                new TestCaseStats(80, 75, 72, 3)
            ),
            new TeamTestingProgress(
                "团队B",
                Arrays.asList(30, 60, 85, 100),
                new TestCaseStats(120, 105, 103, 2)
            )
        );
        
        return new TestingProgressData(labels, plannedTesting, actualTesting, totalStats, teams);
    }
} 