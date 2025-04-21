package com.example.dashboard.service;

import com.example.dashboard.model.BugProgressData;
import com.example.dashboard.model.TeamBugProgress;
import com.example.dashboard.model.BugSeverity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class BugProgressService {
    
    public BugProgressData getBugProgressData() {
        List<String> labels = Arrays.asList("第1周", "第2周", "第3周", "第4周");
        List<Integer> newBugs = Arrays.asList(10, 15, 8, 5);
        List<Integer> fixedBugs = Arrays.asList(8, 12, 10, 4);
        List<Integer> remainingBugs = Arrays.asList(2, 5, 3, 4);
        
        BugSeverity totalSeverity = new BugSeverity(2, 5, 8, 3);
        
        List<TeamBugProgress> teams = Arrays.asList(
            new TeamBugProgress(
                "团队A",
                Arrays.asList(4, 6, 3, 2),
                Arrays.asList(3, 5, 4, 2),
                Arrays.asList(1, 2, 1, 1),
                new BugSeverity(1, 2, 3, 1)
            ),
            new TeamBugProgress(
                "团队B",
                Arrays.asList(6, 9, 5, 3),
                Arrays.asList(5, 7, 6, 2),
                Arrays.asList(1, 3, 2, 3),
                new BugSeverity(1, 3, 5, 2)
            )
        );
        
        return new BugProgressData(labels, newBugs, fixedBugs, remainingBugs, totalSeverity, teams);
    }
} 