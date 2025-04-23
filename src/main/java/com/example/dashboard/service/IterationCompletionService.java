package com.example.dashboard.service;

import com.example.dashboard.entity.IterationCompletionData;
import com.example.dashboard.entity.TeamProgressData;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class IterationCompletionService {
    public IterationCompletionData getIterationCompletionData() {
        List<TeamProgressData> teams = new ArrayList<>();
        try {
            ClassPathResource resource = new ClassPathResource("data/iteration_completion.csv");
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
                    
                    teams.add(new TeamProgressData(programName, teamName, plannedCount, completedCount,
                                                 storypointPlanned, storypointCompleted));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new IterationCompletionData(teams);
    }
} 