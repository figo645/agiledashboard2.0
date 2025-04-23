package com.example.dashboard.controller;

import com.example.dashboard.entity.SprintPlanningData;
import com.example.dashboard.service.SprintPlanningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SprintPlanningController {
    @Autowired
    private SprintPlanningService sprintPlanningService;

    @GetMapping("/sprint-planning")
    public SprintPlanningData getSprintPlanningData() {
        return sprintPlanningService.getSprintPlanningData();
    }
} 