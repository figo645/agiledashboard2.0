package com.example.dashboard.service;

import com.example.dashboard.entity.TeamTestingData;
import com.example.dashboard.entity.TestingProgressData;
import com.example.dashboard.util.CsvReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TestingProgressService {
    @Autowired
    private CsvReader csvReader;

    public TestingProgressData getTestingProgressData() {
        List<TeamTestingData> teams = new ArrayList<>();
        List<String[]> data = csvReader.readCsv("data/testing_progress.csv");
        
        // 跳过标题行
        for (int i = 1; i < data.size(); i++) {
            String[] row = data.get(i);
            teams.add(new TeamTestingData(
                row[0], // teamName
                Integer.parseInt(row[1].trim()), // totalTestCases
                Integer.parseInt(row[2].trim()), // completedTestCases
                Integer.parseInt(row[3].trim()), // failedTestCases
                Integer.parseInt(row[4].trim())  // blockedTestCases
            ));
        }
        
        return new TestingProgressData(teams);
    }
} 