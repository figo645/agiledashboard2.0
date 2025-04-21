package com.example.dashboard.controller;

import com.example.dashboard.model.TestingProgressData;
import com.example.dashboard.service.TestingProgressService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/testing")
public class TestingProgressController {
    
    private final TestingProgressService testingProgressService;
    
    public TestingProgressController(TestingProgressService testingProgressService) {
        this.testingProgressService = testingProgressService;
    }
    
    @GetMapping("/progress")
    public TestingProgressData getTestingProgressData() {
        return testingProgressService.getTestingProgressData();
    }
} 