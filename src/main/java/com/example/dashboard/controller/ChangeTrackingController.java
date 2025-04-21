package com.example.dashboard.controller;

import com.example.dashboard.entity.ChangeData;
import com.example.dashboard.service.ChangeTrackingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/change-tracking")
public class ChangeTrackingController {
    private final ChangeTrackingService changeTrackingService;

    public ChangeTrackingController(ChangeTrackingService changeTrackingService) {
        this.changeTrackingService = changeTrackingService;
    }

    @GetMapping
    public List<ChangeData> getChangeTrackingData() throws Exception {
        return changeTrackingService.getChangeTrackingData();
    }
} 