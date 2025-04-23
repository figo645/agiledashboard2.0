package com.example.dashboard.entity;

import java.util.List;

public class IterationCompletionData {
    private List<WeekData> weeks;

    public IterationCompletionData(List<WeekData> weeks) {
        this.weeks = weeks;
    }

    public List<WeekData> getWeeks() {
        return weeks;
    }

    public void setWeeks(List<WeekData> weeks) {
        this.weeks = weeks;
    }
} 