package com.example.dashboard.entity;

import java.util.List;

public class ChangeTrackingData {
    private List<ChangeWeekData> weeks;

    public ChangeTrackingData(List<ChangeWeekData> weeks) {
        this.weeks = weeks;
    }

    public List<ChangeWeekData> getWeeks() {
        return weeks;
    }

    public void setWeeks(List<ChangeWeekData> weeks) {
        this.weeks = weeks;
    }
} 