package com.example.dashboard.controller;

import com.example.dashboard.model.*;
import com.example.dashboard.service.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DashboardController {
    
    private final SprintPlanningService sprintPlanningService;
    private final IterationCompletionService iterationCompletionService;
    private final ChangeTrackingService changeTrackingService;
    private final TestingProgressService testingProgressService;
    private final BugProgressService bugProgressService;
    
    public DashboardController(
            SprintPlanningService sprintPlanningService,
            IterationCompletionService iterationCompletionService,
            ChangeTrackingService changeTrackingService,
            TestingProgressService testingProgressService,
            BugProgressService bugProgressService) {
        this.sprintPlanningService = sprintPlanningService;
        this.iterationCompletionService = iterationCompletionService;
        this.changeTrackingService = changeTrackingService;
        this.testingProgressService = testingProgressService;
        this.bugProgressService = bugProgressService;
    }
    
    @GetMapping("/api/sprint_planning")
    public SprintPlanningData getSprintPlanningData() {
        return sprintPlanningService.getSprintPlanningData();
    }
    
    @GetMapping("/api/iteration_completion")
    public IterationCompletionData getIterationCompletionData() {
        return iterationCompletionService.getIterationCompletionData();
    }
    
    @GetMapping("/api/change_tracking")
    public ChangeTrackingData getChangeTrackingData() {
        return changeTrackingService.getChangeTrackingData();
    }
    
    @GetMapping("/api/testing_progress")
    public TestingProgressData getTestingProgressData() {
        return testingProgressService.getTestingProgressData();
    }
    
    @GetMapping("/api/bug_progress")
    public BugProgressData getBugProgressData() {
        return bugProgressService.getBugProgressData();
    }
} 