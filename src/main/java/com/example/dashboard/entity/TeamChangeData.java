package com.example.dashboard.entity;

public class TeamChangeData {
    private String teamName;
    private int insertedTasks;
    private int removedTasks;
    private int originalTasks;

    public TeamChangeData(String teamName, int insertedTasks, int removedTasks, int originalTasks) {
        this.teamName = teamName;
        this.insertedTasks = insertedTasks;
        this.removedTasks = removedTasks;
        this.originalTasks = originalTasks;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
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
} 