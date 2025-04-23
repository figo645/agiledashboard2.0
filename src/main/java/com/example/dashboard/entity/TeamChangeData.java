package com.example.dashboard.entity;

public class TeamChangeData {
    private String teamName;
    private int changeTasks;
    private int changePoints;
    private int originalTasks;

    public TeamChangeData(String teamName, int changeTasks, int changePoints, int originalTasks) {
        this.teamName = teamName;
        this.changeTasks = changeTasks;
        this.changePoints = changePoints;
        this.originalTasks = originalTasks;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getChangeTasks() {
        return changeTasks;
    }

    public void setChangeTasks(int changeTasks) {
        this.changeTasks = changeTasks;
    }

    public int getChangePoints() {
        return changePoints;
    }

    public void setChangePoints(int changePoints) {
        this.changePoints = changePoints;
    }

    public int getOriginalTasks() {
        return originalTasks;
    }

    public void setOriginalTasks(int originalTasks) {
        this.originalTasks = originalTasks;
    }
} 