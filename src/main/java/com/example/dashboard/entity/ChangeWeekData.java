package com.example.dashboard.entity;

public class ChangeWeekData {
    private int weekNumber;
    private int insertedTasks;
    private int originalTasks;
    private int removedTasks;
    private int teamAInserted;
    private int teamAOriginal;
    private int teamARemoved;

    public ChangeWeekData(int weekNumber, int insertedTasks, int originalTasks, int removedTasks,
                         int teamAInserted, int teamAOriginal, int teamARemoved) {
        this.weekNumber = weekNumber;
        this.insertedTasks = insertedTasks;
        this.originalTasks = originalTasks;
        this.removedTasks = removedTasks;
        this.teamAInserted = teamAInserted;
        this.teamAOriginal = teamAOriginal;
        this.teamARemoved = teamARemoved;
    }

    // Getters and Setters
    public int getWeekNumber() {
        return weekNumber;
    }

    public void setWeekNumber(int weekNumber) {
        this.weekNumber = weekNumber;
    }

    public int getInsertedTasks() {
        return insertedTasks;
    }

    public void setInsertedTasks(int insertedTasks) {
        this.insertedTasks = insertedTasks;
    }

    public int getOriginalTasks() {
        return originalTasks;
    }

    public void setOriginalTasks(int originalTasks) {
        this.originalTasks = originalTasks;
    }

    public int getRemovedTasks() {
        return removedTasks;
    }

    public void setRemovedTasks(int removedTasks) {
        this.removedTasks = removedTasks;
    }

    public int getTeamAInserted() {
        return teamAInserted;
    }

    public void setTeamAInserted(int teamAInserted) {
        this.teamAInserted = teamAInserted;
    }

    public int getTeamAOriginal() {
        return teamAOriginal;
    }

    public void setTeamAOriginal(int teamAOriginal) {
        this.teamAOriginal = teamAOriginal;
    }

    public int getTeamARemoved() {
        return teamARemoved;
    }

    public void setTeamARemoved(int teamARemoved) {
        this.teamARemoved = teamARemoved;
    }
} 