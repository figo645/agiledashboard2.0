package com.example.dashboard.entity;

import java.util.List;

public class ChangeTrackingData {
    private List<WeekChangeData> weeks;

    public ChangeTrackingData(List<WeekChangeData> weeks) {
        this.weeks = weeks;
    }

    public List<WeekChangeData> getWeeks() {
        return weeks;
    }

    public void setWeeks(List<WeekChangeData> weeks) {
        this.weeks = weeks;
    }
} 