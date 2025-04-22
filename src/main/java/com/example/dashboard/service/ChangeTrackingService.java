package com.example.dashboard.service;

import com.example.dashboard.model.ChangeTrackingData;
import com.example.dashboard.model.TeamChanges;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ChangeTrackingService {
    
    public ChangeTrackingData getChangeTrackingData() {
        List<String> labels = Arrays.asList("第1周", "第2周", "第3周", "第4周");
        List<Integer> newTasks = Arrays.asList(5, 8, 3, 2);
        List<Integer> modifiedTasks = Arrays.asList(2, 3, 1, 1);
        List<Integer> removedTasks = Arrays.asList(1, 0, 2, 0);
        
        List<TeamChanges> teams = Arrays.asList(
            new TeamChanges("团队A", 
                Arrays.asList(3, 4, 2, 1),
                Arrays.asList(1, 2, 1, 0),
                Arrays.asList(0, 0, 1, 0)
            ),
            new TeamChanges("团队B",
                Arrays.asList(2, 4, 1, 1),
                Arrays.asList(1, 1, 0, 1),
                Arrays.asList(1, 0, 1, 0)
            )
        );
        
        return new ChangeTrackingData(labels, newTasks, modifiedTasks, removedTasks, teams);
    }
} 