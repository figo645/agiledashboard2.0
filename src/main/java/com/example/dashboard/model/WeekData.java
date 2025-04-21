package com.example.dashboard.model;

public class WeekData {
    private final int week;
    private final int plannedProgress;
    private final int actualProgress;
    private final int teamAPlanned;
    private final int teamAActual;
    private final int teamBPlanned;
    private final int teamBActual;

    public WeekData(int week, int plannedProgress, int actualProgress, 
                   int teamAPlanned, int teamAActual, 
                   int teamBPlanned, int teamBActual) {
        this.week = week;
        this.plannedProgress = plannedProgress;
        this.actualProgress = actualProgress;
        this.teamAPlanned = teamAPlanned;
        this.teamAActual = teamAActual;
        this.teamBPlanned = teamBPlanned;
        this.teamBActual = teamBActual;
    }

    // Getters
    public int getWeek() {
        return week;
    }

    public int getPlannedProgress() {
        return plannedProgress;
    }

    public int getActualProgress() {
        return actualProgress;
    }

    public int getTeamAPlanned() {
        return teamAPlanned;
    }

    public int getTeamAActual() {
        return teamAActual;
    }

    public int getTeamBPlanned() {
        return teamBPlanned;
    }

    public int getTeamBActual() {
        return teamBActual;
    }
} 