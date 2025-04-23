package com.example.dashboard.service;

import com.example.dashboard.entity.SprintPlanningData;
import com.example.dashboard.entity.TeamData;
import com.example.dashboard.util.CsvReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SprintPlanningService {
    @Autowired
    private CsvReader csvReader;

    public SprintPlanningData getSprintPlanningData() {
        List<TeamData> teams = new ArrayList<>();
        List<String[]> data = csvReader.readCsv("data/sprint_planning.csv");
        
        // 跳过标题行
        for (int i = 1; i < data.size(); i++) {
            String[] row = data.get(i);
            teams.add(new TeamData(
                row[0], // teamName
                Integer.parseInt(row[1].trim()), // teamSize
                Integer.parseInt(row[2].trim()), // totalPoints
                Integer.parseInt(row[3].trim()), // pointsPerPerson
                Integer.parseInt(row[4].trim()), // developmentPercentage
                Integer.parseInt(row[5].trim()), // testingPercentage
                Integer.parseInt(row[6].trim()), // documentationPercentage
                Integer.parseInt(row[7].trim()), // testingRate
                Integer.parseInt(row[8].trim())  // delayCards
            ));
        }
        return new SprintPlanningData(teams);
    }
} 