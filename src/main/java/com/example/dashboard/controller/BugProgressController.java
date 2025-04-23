package com.example.dashboard.controller;

import com.example.dashboard.entity.BugProgressData;
import com.example.dashboard.service.BugProgressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BugProgressController {

    @Autowired
    private BugProgressService bugProgressService;

    @GetMapping("/bug-progress")
    public BugProgressData getBugProgressData() {
        return bugProgressService.getBugProgressData();
    }
} 