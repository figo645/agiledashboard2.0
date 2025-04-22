package com.example.dashboard.entity;

import lombok.Data;
import java.util.List;

@Data
public class ChangeTrackingData {
    private List<WeekChangeData> weeks;

    public ChangeTrackingData(List<WeekChangeData> weeks) {
        this.weeks = weeks;
    }
} 