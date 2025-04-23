package com.example.dashboard.entity;

public class TeamTestingData {
    private String teamName;
    private int totalTestCases;
    private int completedTestCases;
    private int failedTestCases;
    private int blockedTestCases;

    public TeamTestingData(String teamName, int totalTestCases, int completedTestCases,
                          int failedTestCases, int blockedTestCases) {
        this.teamName = teamName;
        this.totalTestCases = totalTestCases;
        this.completedTestCases = completedTestCases;
        this.failedTestCases = failedTestCases;
        this.blockedTestCases = blockedTestCases;
    }

    // Getters and Setters
    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getTotalTestCases() {
        return totalTestCases;
    }

    public void setTotalTestCases(int totalTestCases) {
        this.totalTestCases = totalTestCases;
    }

    public int getCompletedTestCases() {
        return completedTestCases;
    }

    public void setCompletedTestCases(int completedTestCases) {
        this.completedTestCases = completedTestCases;
    }

    public int getFailedTestCases() {
        return failedTestCases;
    }

    public void setFailedTestCases(int failedTestCases) {
        this.failedTestCases = failedTestCases;
    }

    public int getBlockedTestCases() {
        return blockedTestCases;
    }

    public void setBlockedTestCases(int blockedTestCases) {
        this.blockedTestCases = blockedTestCases;
    }
} 