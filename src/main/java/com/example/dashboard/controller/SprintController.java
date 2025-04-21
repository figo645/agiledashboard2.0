package com.example.dashboard.controller;

import com.example.dashboard.model.SprintData;
import com.example.dashboard.service.SprintService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SprintController {
    
    private final SprintService sprintService;
    
    public SprintController(SprintService sprintService) {
        this.sprintService = sprintService;
    }
    
    @GetMapping("/sprint")
    public SprintData getSprintData() {
        return sprintService.getSprintData();
    }
} 