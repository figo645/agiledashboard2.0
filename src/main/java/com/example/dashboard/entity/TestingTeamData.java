package com.example.dashboard.entity;

public class TestingTeamData {
    private String teamName;
    private int actualTesting;
    private int plannedTesting;
    private int totalTestCases;
    private int passedTestCases;
    private int failedTestCases;

    public TestingTeamData(String teamName, int actualTesting, int plannedTesting,
                          int totalTestCases, int passedTestCases, int failedTestCases) {
        this.teamName = teamName;
        this.actualTesting = actualTesting;
        this.plannedTesting = plannedTesting;
        this.totalTestCases = totalTestCases;
        this.passedTestCases = passedTestCases;
        this.failedTestCases = failedTestCases;
    }

    // Getters and Setters
    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getActualTesting() {
        return actualTesting;
    }

    public void setActualTesting(int actualTesting) {
        this.actualTesting = actualTesting;
    }

    public int getPlannedTesting() {
        return plannedTesting;
    }

    public void setPlannedTesting(int plannedTesting) {
        this.plannedTesting = plannedTesting;
    }

    public int getTotalTestCases() {
        return totalTestCases;
    }

    public void setTotalTestCases(int totalTestCases) {
        this.totalTestCases = totalTestCases;
    }

    public int getPassedTestCases() {
        return passedTestCases;
    }

    public void setPassedTestCases(int passedTestCases) {
        this.passedTestCases = passedTestCases;
    }

    public int getFailedTestCases() {
        return failedTestCases;
    }

    public void setFailedTestCases(int failedTestCases) {
        this.failedTestCases = failedTestCases;
    }
} 