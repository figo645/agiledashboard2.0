package com.example.dashboard.entity;

public class TeamChangeData {
    private String teamName;
    private int insertedTasks;
    private int originalTasks;
    private int removedTasks;

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
} 