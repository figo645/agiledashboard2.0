package com.example.dashboard.entity;

public class WeekChangeData {
    private int week;
    private int insertedTasks;
    private int removedTasks;
    private int originalTasks;
    private int teamAChanges;
    private int teamBChanges;

    public WeekChangeData(int week, int insertedTasks, int removedTasks,
                         int originalTasks, int teamAChanges, int teamBChanges) {
        this.week = week;
        this.insertedTasks = insertedTasks;
        this.removedTasks = removedTasks;
        this.originalTasks = originalTasks;
        this.teamAChanges = teamAChanges;
        this.teamBChanges = teamBChanges;
    }

    // Getters and Setters
    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public int getInsertedTasks() {
        return insertedTasks;
    }

    public void setInsertedTasks(int insertedTasks) {
        this.insertedTasks = insertedTasks;
    }

    public int getRemovedTasks() {
        return removedTasks;
    }

    public void setRemovedTasks(int removedTasks) {
        this.removedTasks = removedTasks;
    }

    public int getOriginalTasks() {
        return originalTasks;
    }

    public void setOriginalTasks(int originalTasks) {
        this.originalTasks = originalTasks;
    }

    public int getTeamAChanges() {
        return teamAChanges;
    }

    public void setTeamAChanges(int teamAChanges) {
        this.teamAChanges = teamAChanges;
    }

    public int getTeamBChanges() {
        return teamBChanges;
    }

    public void setTeamBChanges(int teamBChanges) {
        this.teamBChanges = teamBChanges;
    }
} 