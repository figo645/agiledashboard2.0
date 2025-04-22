package com.example.dashboard.service;

import com.example.dashboard.entity.IterationCompletionData;
import com.example.dashboard.entity.WeekData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IterationCompletionService {
    
    public IterationCompletionData getIterationCompletionData() {
        List<WeekData> weeks = new ArrayList<>();
        weeks.add(new WeekData(1, 25, 20, 30, 25, 20, 15));
        weeks.add(new WeekData(2, 50, 45, 60, 50, 40, 40));
        weeks.add(new WeekData(3, 75, 70, 80, 75, 70, 65));
        weeks.add(new WeekData(4, 100, 95, 100, 95, 100, 95));
        return new IterationCompletionData(weeks);
    }
} 