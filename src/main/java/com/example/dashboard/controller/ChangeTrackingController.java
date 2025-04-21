package com.example.dashboard.controller;

import com.example.dashboard.model.ChangeTrackingData;
import com.example.dashboard.service.ChangeTrackingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/change")
public class ChangeTrackingController {
    
    private final ChangeTrackingService changeTrackingService;
    
    public ChangeTrackingController(ChangeTrackingService changeTrackingService) {
        this.changeTrackingService = changeTrackingService;
    }
    
    @GetMapping("/tracking")
    public ChangeTrackingData getChangeTrackingData() {
        return changeTrackingService.getChangeTrackingData();
    }
} 