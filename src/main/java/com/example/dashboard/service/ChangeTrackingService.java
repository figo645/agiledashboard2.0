package com.example.dashboard.service;

import com.example.dashboard.entity.ChangeTrackingData;
import com.example.dashboard.entity.WeekChangeData;
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
        List<WeekChangeData> weeks = new ArrayList<>();
        List<String[]> data = csvReader.readCsv("data/change_tracking.csv");
        
        // 跳过标题行
        for (int i = 1; i < data.size(); i++) {
            String[] row = data.get(i);
            weeks.add(new WeekChangeData(
                Integer.parseInt(row[0]), // week
                Integer.parseInt(row[1]), // insertedTasks
                Integer.parseInt(row[2]), // removedTasks
                Integer.parseInt(row[3]), // originalTasks
                Integer.parseInt(row[4]), // teamAChanges
                Integer.parseInt(row[5])  // teamBChanges
            ));
        }
        return new ChangeTrackingData(weeks);
    }
} 