package com.example.dashboard.controller;

import com.example.dashboard.model.IterationCompletionData;
import com.example.dashboard.service.IterationCompletionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/iteration")
public class IterationCompletionController {
    
    private final IterationCompletionService iterationCompletionService;
    
    public IterationCompletionController(IterationCompletionService iterationCompletionService) {
        this.iterationCompletionService = iterationCompletionService;
    }
    
    @GetMapping("/completion")
    public IterationCompletionData getIterationCompletionData() {
        return iterationCompletionService.getIterationCompletionData();
    }
} 