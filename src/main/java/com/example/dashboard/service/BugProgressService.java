package com.example.dashboard.service;

import com.example.dashboard.entity.BugData;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class BugProgressService {
    private final DataService dataService;

    public BugProgressService(DataService dataService) {
        this.dataService = dataService;
    }

    public List<BugData> getBugProgressData() throws IOException {
        return dataService.readJsonFile("bug_progress.json", List.class);
    }
} 