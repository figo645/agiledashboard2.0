package com.example.dashboard.service;

import com.example.dashboard.entity.IterationCompletionData;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class IterationCompletionService {
    private final DataService dataService;

    public IterationCompletionService(DataService dataService) {
        this.dataService = dataService;
    }

    public IterationCompletionData getIterationCompletionData() throws IOException {
        return dataService.readJsonFile("iteration_completion.json", IterationCompletionData.class);
    }
} 