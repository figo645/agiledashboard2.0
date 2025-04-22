package com.example.dashboard.entity;

import lombok.Data;
import java.util.List;

@Data
public class IterationCompletionData {
    private List<WeekData> weeks;

    public IterationCompletionData(List<WeekData> weeks) {
        this.weeks = weeks;
    }
} 