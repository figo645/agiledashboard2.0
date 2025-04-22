package com.example.dashboard.service;

import com.example.dashboard.entity.ChangeData;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ChangeTrackingService {
    private final DataService dataService;

    public ChangeTrackingService(DataService dataService) {
        this.dataService = dataService;
    }

    public List<ChangeData> getChangeTrackingData() throws IOException {
        return dataService.readJsonFile("change_tracking.json", List.class);
    }
} 