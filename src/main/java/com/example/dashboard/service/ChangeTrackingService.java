package com.example.dashboard.service;

import com.example.dashboard.entity.ChangeTrackingData;
import com.example.dashboard.entity.TeamChangeData;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class ChangeTrackingService {
    public ChangeTrackingData getChangeTrackingData() {
        List<TeamChangeData> teams = new ArrayList<>();
        try {
            ClassPathResource resource = new ClassPathResource("data/change_tracking.csv");
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()))) {
                String line;
                // Skip header
                reader.readLine();
                while ((line = reader.readLine()) != null) {
                    String[] values = line.split(",");
                    String teamName = values[0].trim();
                    int changeTasks = Integer.parseInt(values[1].trim());
                    int changePoints = Integer.parseInt(values[2].trim());
                    
                    teams.add(new TeamChangeData(teamName, changeTasks, changePoints, 0));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ChangeTrackingData(teams);
    }
} 