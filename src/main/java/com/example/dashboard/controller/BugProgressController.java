package com.example.dashboard.controller;

import com.example.dashboard.model.BugProgressData;
import com.example.dashboard.service.BugProgressService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bug")
public class BugProgressController {
    
    private final BugProgressService bugProgressService;
    
    public BugProgressController(BugProgressService bugProgressService) {
        this.bugProgressService = bugProgressService;
    }
    
    @GetMapping("/progress")
    public BugProgressData getBugProgressData() {
        return bugProgressService.getBugProgressData();
    }
} 