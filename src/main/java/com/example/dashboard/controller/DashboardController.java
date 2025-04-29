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
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
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
    public List<TeamData> getSprintPlanningData(@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return sprintPlanningService.getSprintPlanningData(date);
    }

    @GetMapping("/iteration-completion")
    public List<IterationCompletion> getIterationCompletionData(@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return iterationCompletionService.getIterationCompletionData(date);
    }

    @GetMapping("/bug-progress")
    public List<BugProgress> getBugProgressData(@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return bugService.getBugProgressData(date);
    }

    @GetMapping("/change-tracking")
    public List<ChangeTracking> getChangeTrackingData(@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return changeService.getChangeTrackingData(date);
    }

    @GetMapping("/testing-progress")
    public List<TestingProgress> getTestingProgressData(@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return testingService.getTestingProgressData(date);
    }
} 