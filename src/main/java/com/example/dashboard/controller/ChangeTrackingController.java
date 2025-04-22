package com.example.dashboard.controller;

import com.example.dashboard.entity.ChangeTrackingData;
import com.example.dashboard.service.ChangeTrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ChangeTrackingController {

    @Autowired
    private ChangeTrackingService changeTrackingService;

    @GetMapping("/changeChart")
    public ChangeTrackingData getChangeChartData() {
        return changeTrackingService.getChangeTrackingData();
    }
} 