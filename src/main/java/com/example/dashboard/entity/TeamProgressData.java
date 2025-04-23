package com.example.dashboard.entity;

public class TeamProgressData {
    private String teamName;
    private int plannedProgress;
    private int actualProgress;

    public TeamProgressData(String teamName, int plannedProgress, int actualProgress) {
        this.teamName = teamName;
        this.plannedProgress = plannedProgress;
        this.actualProgress = actualProgress;
    }

    // Getters and Setters
    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
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