package com.example.dashboard.service;

import com.example.dashboard.entity.ChangeTrackingData;
import com.example.dashboard.entity.ChangeWeekData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChangeTrackingService {
    public ChangeTrackingData getChangeTrackingData() {
        List<ChangeWeekData> weeks = new ArrayList<>();
        
        // 第1周数据
        weeks.add(new ChangeWeekData(1, 3, 15, 2, 2, 12, 1));
        
        // 第2周数据
        weeks.add(new ChangeWeekData(2, 4, 20, 3, 3, 16, 2));
        
        // 第3周数据
        weeks.add(new ChangeWeekData(3, 2, 18, 1, 2, 15, 1));
        
        // 第4周数据
        weeks.add(new ChangeWeekData(4, 3, 22, 2, 3, 18, 2));

        return new ChangeTrackingData(weeks);
    }
} 