package com.example.dashboard.model;

public class WeekTestingData {
    private final int week;
    private final int plannedTesting;
    private final int actualTesting;
    private final int totalTestCases;
    private final int passedTestCases;
    private final int failedTestCases;

    public WeekTestingData(int week, int plannedTesting, int actualTesting, 
                          int totalTestCases, int passedTestCases, int failedTestCases) {
        this.week = week;
        this.plannedTesting = plannedTesting;
        this.actualTesting = actualTesting;
        this.totalTestCases = totalTestCases;
        this.passedTestCases = passedTestCases;
        this.failedTestCases = failedTestCases;
    }

    public int getWeek() {
        return week;
    }

    public int getPlannedTesting() {
        return plannedTesting;
    }

    public int getActualTesting() {
        return actualTesting;
    }

    public int getTotalTestCases() {
        return totalTestCases;
    }

    public int getPassedTestCases() {
        return passedTestCases;
    }

    public int getFailedTestCases() {
        return failedTestCases;
    }
} 