package com.example.dashboard.entity;

public class WeekData {
    private int week;
    private int plannedProgress;
    private int actualProgress;

    public WeekData(int week, int plannedProgress, int actualProgress) {
        this.week = week;
        this.plannedProgress = plannedProgress;
        this.actualProgress = actualProgress;
    }

    // Getters and Setters
    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public int getPlannedProgress() {
        return plannedProgress;
    }

    public void setPlannedProgress(int plannedProgress) {
        this.plannedProgress = plannedProgress;
    }

    public int getActualProgress() {
        return actualProgress;
    }

    public void setActualProgress(int actualProgress) {
        this.actualProgress = actualProgress;
    }
} 