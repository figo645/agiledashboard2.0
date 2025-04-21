package com.example.dashboard.entity;

public class WeekData {
    private int week;
    private int plannedProgress;
    private int actualProgress;
    private int teamAProgress;
    private int teamBProgress;
    private int teamCProgress;

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

    public int getTeamAProgress() {
        return teamAProgress;
    }

    public void setTeamAProgress(int teamAProgress) {
        this.teamAProgress = teamAProgress;
    }

    public int getTeamBProgress() {
        return teamBProgress;
    }

    public void setTeamBProgress(int teamBProgress) {
        this.teamBProgress = teamBProgress;
    }

    public int getTeamCProgress() {
        return teamCProgress;
    }

    public void setTeamCProgress(int teamCProgress) {
        this.teamCProgress = teamCProgress;
    }
} 