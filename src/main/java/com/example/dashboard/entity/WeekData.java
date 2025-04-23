package com.example.dashboard.entity;

public class WeekData {
    private String week;
    private int plannedProgress;
    private int actualProgress;

    public WeekData(String week, int plannedProgress, int actualProgress) {
        this.week = week;
        this.plannedProgress = plannedProgress;
        this.actualProgress = actualProgress;
    }

    // Getters and Setters
    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
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