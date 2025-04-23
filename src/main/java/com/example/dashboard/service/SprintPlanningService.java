package com.example.dashboard.service;

import com.example.dashboard.entity.SprintPlanningData;
import com.example.dashboard.entity.TeamData;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class SprintPlanningService {
    public SprintPlanningData getSprintPlanningData() {
        List<TeamData> teams = new ArrayList<>();
        try {
            ClassPathResource resource = new ClassPathResource("data/sprint_planning.csv");
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()))) {
                String line;
                // Skip header
                reader.readLine();
                while ((line = reader.readLine()) != null) {
                    String[] values = line.split(",");
                    String programName = values[0].trim();
                    String teamName = values[1].trim();
                    double plannedCount = Double.parseDouble(values[2].trim());
                    double completedCount = Double.parseDouble(values[3].trim());
                    double storypointPlanned = Double.parseDouble(values[4].trim());
                    double storypointCompleted = Double.parseDouble(values[5].trim());
                    double testPoints = Double.parseDouble(values[6].trim());
                    double userStoryPoints = Double.parseDouble(values[7].trim());
                    double userStoryRatio = Double.parseDouble(values[8].trim());
                    double enablerPoints = Double.parseDouble(values[9].trim());
                    double enablerRatio = Double.parseDouble(values[10].trim());
                    double storyThroughput = Double.parseDouble(values[11].trim());
                    
                    teams.add(new TeamData(programName, teamName, plannedCount, completedCount,
                                         storypointPlanned, storypointCompleted, testPoints,
                                         userStoryPoints, userStoryRatio, enablerPoints,
                                         enablerRatio, storyThroughput));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new SprintPlanningData(teams);
    }
} 