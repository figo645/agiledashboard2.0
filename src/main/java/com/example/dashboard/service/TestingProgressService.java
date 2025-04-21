package com.example.dashboard.service;

import com.example.dashboard.entity.TestingData;
import com.example.dashboard.entity.TestingProgressData;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class TestingProgressService {
    private final DataService dataService;

    public TestingProgressService(DataService dataService) {
        this.dataService = dataService;
    }

    public List<TestingData> getTestingProgressData() throws IOException {
        TestingProgressData data = dataService.readJsonFile("testing_progress.json", TestingProgressData.class);
        return data.getTesting();
    }
} 