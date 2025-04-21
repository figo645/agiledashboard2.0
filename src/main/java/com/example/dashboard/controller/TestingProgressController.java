package com.example.dashboard.controller;

import com.example.dashboard.entity.TestingData;
import com.example.dashboard.service.TestingProgressService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/testing-progress")
public class TestingProgressController {
    private final TestingProgressService testingProgressService;

    public TestingProgressController(TestingProgressService testingProgressService) {
        this.testingProgressService = testingProgressService;
    }

    @GetMapping
    public List<TestingData> getTestingProgressData() throws Exception {
        return testingProgressService.getTestingProgressData();
    }
} 