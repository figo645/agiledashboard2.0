package com.example.dashboard.service;

import com.example.dashboard.entity.IterationCompletionData;
import com.example.dashboard.entity.WeekData;
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
        List<WeekData> weeks = new ArrayList<>();
        List<String[]> data = csvReader.readCsv("data/iteration_completion.csv");
        
        // 跳过标题行
        for (int i = 1; i < data.size(); i++) {
            String[] row = data.get(i);
            weeks.add(new WeekData(
                Integer.parseInt(row[0]), // week
                Integer.parseInt(row[1]), // plannedProgress
                Integer.parseInt(row[2])  // actualProgress
            ));
        }
        return new IterationCompletionData(weeks);
    }
} 