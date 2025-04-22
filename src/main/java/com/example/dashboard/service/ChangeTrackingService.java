package com.example.dashboard.service;

import com.example.dashboard.entity.ChangeTrackingData;
import com.example.dashboard.entity.TeamChangeData;
import com.example.dashboard.entity.WeekChangeData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChangeTrackingService {
    
    public ChangeTrackingData getChangeTrackingData() {
        List<WeekChangeData> weeks = new ArrayList<>();
        weeks.add(new WeekChangeData(1, 5, 3, 2, 4, 2));
        weeks.add(new WeekChangeData(2, 8, 5, 3, 6, 3));
        weeks.add(new WeekChangeData(3, 12, 8, 4, 9, 4));
        weeks.add(new WeekChangeData(4, 15, 10, 5, 12, 5));
        return new ChangeTrackingData(weeks);
    }
} 