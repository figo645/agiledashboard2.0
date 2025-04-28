package com.example.dashboard.controller;

import com.example.dashboard.entity.TeamData;
import com.example.dashboard.entity.IterationCompletion;
import com.example.dashboard.entity.BugProgress;
import com.example.dashboard.entity.ChangeTracking;
import com.example.dashboard.entity.TestingProgress;
import com.example.dashboard.service.SprintPlanningService;
import com.example.dashboard.service.IterationCompletionService;
import com.example.dashboard.service.BugService;
import com.example.dashboard.service.ChangeService;
import com.example.dashboard.service.TestingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DashboardController {

    @Autowired
    private SprintPlanningService sprintPlanningService;

    @Autowired
    private IterationCompletionService iterationCompletionService;

    @Autowired
    private BugService bugService;

    @Autowired
    private ChangeService changeService;

    @Autowired
    private TestingService testingService;

    @GetMapping("/sprint-planning")
    public List<TeamData> getSprintPlanningData() {
        return sprintPlanningService.getSprintPlanningData();
    }

    @GetMapping("/iteration-completion")
    public List<IterationCompletion> getIterationCompletionData() {
        return iterationCompletionService.getIterationCompletionData();
    }

    @GetMapping("/bug-progress")
    public List<BugProgress> getBugProgressData() {
        return bugService.getBugProgressData();
    }

    @GetMapping("/change-tracking")
    public List<ChangeTracking> getChangeTrackingData() {
        return changeService.getChangeTrackingData();
    }

    @GetMapping("/testing-progress")
    public List<TestingProgress> getTestingProgressData() {
        return testingService.getTestingProgressData();
    }
} 