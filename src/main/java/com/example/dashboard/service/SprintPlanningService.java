package com.example.dashboard.service;

import com.example.dashboard.entity.SprintData;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class SprintPlanningService {
    private final DataService dataService;

    public SprintPlanningService(DataService dataService) {
        this.dataService = dataService;
    }

    public SprintData getSprintPlanningData() throws IOException {
        return dataService.readJsonFile("sprint_planning.json", SprintData.class);
    }
} 