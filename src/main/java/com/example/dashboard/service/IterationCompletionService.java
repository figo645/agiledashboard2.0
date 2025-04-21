package com.example.dashboard.service;

import com.example.dashboard.model.IterationCompletionData;
import com.example.dashboard.model.TeamProgress;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class IterationCompletionService {
    
    public IterationCompletionData getIterationCompletionData() {
        List<String> labels = Arrays.asList("第1周", "第2周", "第3周", "第4周");
        List<Integer> planned = Arrays.asList(25, 50, 75, 100);
        List<Integer> actual = Arrays.asList(20, 45, 70, 85);
        
        List<TeamProgress> teams = Arrays.asList(
            new TeamProgress("团队A", Arrays.asList(18, 42, 65, 80)),
            new TeamProgress("团队B", Arrays.asList(22, 48, 75, 90)),
            new TeamProgress("团队C", Arrays.asList(20, 45, 70, 85))
        );
        
        return new IterationCompletionData(labels, planned, actual, teams);
    }
} 