package com.example.dashboard.controller;

import com.example.dashboard.entity.SprintData;
import com.example.dashboard.service.SprintPlanningService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sprint-planning")
public class SprintPlanningController {
    private final SprintPlanningService sprintPlanningService;

    public SprintPlanningController(SprintPlanningService sprintPlanningService) {
        this.sprintPlanningService = sprintPlanningService;
    }

    @GetMapping
    public SprintData getSprintPlanningData() throws Exception {
        return sprintPlanningService.getSprintPlanningData();
    }
} 