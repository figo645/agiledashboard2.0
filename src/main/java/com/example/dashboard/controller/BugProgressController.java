package com.example.dashboard.controller;

import com.example.dashboard.entity.BugData;
import com.example.dashboard.service.BugProgressService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/bug-progress")
public class BugProgressController {
    private final BugProgressService bugProgressService;

    public BugProgressController(BugProgressService bugProgressService) {
        this.bugProgressService = bugProgressService;
    }

    @GetMapping
    public List<BugData> getBugProgressData() throws Exception {
        return bugProgressService.getBugProgressData();
    }
} 