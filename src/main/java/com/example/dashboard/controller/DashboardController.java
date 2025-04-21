package com.example.dashboard.controller;

import com.example.dashboard.entity.*;
import com.example.dashboard.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
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
    public List<TeamData> getSprintPlanningData() throws IOException {
        return sprintPlanningService.getSprintPlanningData().getTeams();
    }

    @GetMapping("/iteration-completion")
    public IterationCompletionData getIterationCompletionData() throws IOException {
        return iterationCompletionService.getIterationCompletionData();
    }

    @GetMapping("/change-tracking")
    public List<ChangeData> getChangeTrackingData() throws IOException {
        return changeTrackingService.getChangeTrackingData();
    }

    @GetMapping("/testing-progress")
    public List<TestingData> getTestingProgressData() throws IOException {
        return testingProgressService.getTestingProgressData();
    }

    @GetMapping("/bug-progress")
    public List<BugData> getBugProgressData() throws IOException {
        return bugProgressService.getBugProgressData();
    }
} 