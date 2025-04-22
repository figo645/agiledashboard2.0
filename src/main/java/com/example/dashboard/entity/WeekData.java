package com.example.dashboard.entity;

public class WeekData {
    private int weekNumber;
    private int plannedTasks;
    private int completedTasks;
    private int teamAPlanned;
    private int teamAActual;
    private int teamBPlanned;
    private int teamBActual;

    public WeekData(int weekNumber, int plannedTasks, int completedTasks,
                   int teamAPlanned, int teamAActual, int teamBPlanned, int teamBActual) {
        this.weekNumber = weekNumber;
        this.plannedTasks = plannedTasks;
        this.completedTasks = completedTasks;
        this.teamAPlanned = teamAPlanned;
        this.teamAActual = teamAActual;
        this.teamBPlanned = teamBPlanned;
        this.teamBActual = teamBActual;
    }

    // Getters and Setters
    public int getWeekNumber() {
        return weekNumber;
    }

    public void setWeekNumber(int weekNumber) {
        this.weekNumber = weekNumber;
    }

    public int getPlannedTasks() {
        return plannedTasks;
    }

    public void setPlannedTasks(int plannedTasks) {
        this.plannedTasks = plannedTasks;
    }

    public int getCompletedTasks() {
        return completedTasks;
    }

    public void setCompletedTasks(int completedTasks) {
        this.completedTasks = completedTasks;
    }

    public int getTeamAPlanned() {
        return teamAPlanned;
    }

    public void setTeamAPlanned(int teamAPlanned) {
        this.teamAPlanned = teamAPlanned;
    }

    public int getTeamAActual() {
        return teamAActual;
    }

    public void setTeamAActual(int teamAActual) {
        this.teamAActual = teamAActual;
    }

    public int getTeamBPlanned() {
        return teamBPlanned;
    }

    public void setTeamBPlanned(int teamBPlanned) {
        this.teamBPlanned = teamBPlanned;
    }

    public int getTeamBActual() {
        return teamBActual;
    }

    public void setTeamBActual(int teamBActual) {
        this.teamBActual = teamBActual;
    }
} 