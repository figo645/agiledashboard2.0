package com.example.dashboard.service;

import com.example.dashboard.entity.ChangeTrackingData;
import com.example.dashboard.entity.TeamChangeData;
import com.example.dashboard.util.CsvReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChangeTrackingService {
    @Autowired
    private CsvReader csvReader;

    public ChangeTrackingData getChangeTrackingData() {
        List<TeamChangeData> teams = new ArrayList<>();
        List<String[]> data = csvReader.readCsv("data/change_tracking.csv");
        
        // 跳过标题行
        for (int i = 1; i < data.size(); i++) {
            String[] row = data.get(i);
            teams.add(new TeamChangeData(
                row[0], // teamName
                Integer.parseInt(row[1].trim()), // insertedTasks
                Integer.parseInt(row[2].trim()), // removedTasks
                Integer.parseInt(row[3].trim())  // originalTasks
            ));
        }
        return new ChangeTrackingData(teams);
    }
} 