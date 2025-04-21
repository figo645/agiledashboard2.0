package com.example.dashboard.model;

public class WeekChangeData {
    private final int week;
    private final int newTasks;
    private final int modifiedTasks;
    private final int removedTasks;

    public WeekChangeData(int week, int newTasks, int modifiedTasks, int removedTasks) {
        this.week = week;
        this.newTasks = newTasks;
        this.modifiedTasks = modifiedTasks;
        this.removedTasks = removedTasks;
    }

    public int getWeek() {
        return week;
    }

    public int getNewTasks() {
        return newTasks;
    }

    public int getModifiedTasks() {
        return modifiedTasks;
    }

    public int getRemovedTasks() {
        return removedTasks;
    }
} 