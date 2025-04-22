package com.example.dashboard.controller;

import com.example.dashboard.entity.IterationCompletionData;
import com.example.dashboard.service.IterationCompletionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class IterationCompletionController {

    @Autowired
    private IterationCompletionService iterationCompletionService;

    @GetMapping("/completionChart")
    public IterationCompletionData getCompletionChartData() {
        return iterationCompletionService.getIterationCompletionData();
    }
} 