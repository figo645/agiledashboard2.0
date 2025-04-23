package com.example.dashboard.controller;

import com.example.dashboard.entity.*;
import com.example.dashboard.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dashboard/api")
public class DashboardController {
    @Autowired
    private SprintPlanningService sprintPlanningService;
    
    @Autowired
    private IterationCompletionService iterationCompletionService;
    
    @Autowired
    private ChangeTrackingService changeTrackingService;
    
    @Autowired
    private TestingProgressService testingProgressService;
    
    @Autowired
    private BugProgressService bugProgressService;

    @GetMapping("/sprint-planning")
    public SprintPlanningData getSprintPlanningData() {
        return sprintPlanningService.getSprintPlanningData();
    }

    @GetMapping("/iteration-completion")
    public IterationCompletionData getIterationCompletionData() {
        return iterationCompletionService.getIterationCompletionData();
    }

    @GetMapping("/change-tracking")
    public ChangeTrackingData getChangeTrackingData() {
        return changeTrackingService.getChangeTrackingData();
    }

    @GetMapping("/testing-progress")
    public TestingProgressData getTestingProgressData() {
        return testingProgressService.getTestingProgressData();
    }

    @GetMapping("/bug-progress")
    public BugProgressData getBugProgressData() {
        return bugProgressService.getBugProgressData();
    }
} 