package com.example.dashboard.service;

import com.example.dashboard.entity.IterationCompletionData;
import com.example.dashboard.entity.TeamProgressData;
import com.example.dashboard.util.CsvReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IterationCompletionService {
    @Autowired
    private CsvReader csvReader;

    public IterationCompletionData getIterationCompletionData() {
        List<TeamProgressData> teams = new ArrayList<>();
        List<String[]> data = csvReader.readCsv("data/iteration_completion.csv");
        
        // 跳过标题行
        for (int i = 1; i < data.size(); i++) {
            String[] row = data.get(i);
            teams.add(new TeamProgressData(
                row[0], // teamName
                Integer.parseInt(row[1].trim()), // plannedProgress
                Integer.parseInt(row[2].trim())  // actualProgress
            ));
        }
        return new IterationCompletionData(teams);
    }
} 