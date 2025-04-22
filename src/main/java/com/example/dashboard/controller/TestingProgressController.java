package com.example.dashboard.controller;

import com.example.dashboard.entity.TestingProgressData;
import com.example.dashboard.service.TestingProgressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestingProgressController {

    @Autowired
    private TestingProgressService testingProgressService;

    @GetMapping("/testingChart")
    public TestingProgressData getTestingChartData() {
        return testingProgressService.getTestingProgressData();
    }
} 