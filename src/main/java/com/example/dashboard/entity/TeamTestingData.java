package com.example.dashboard.entity;

import lombok.Data;

@Data
public class TeamTestingData {
    private String teamName;
    private int totalTestCases;
    private int completedTestCases;
    private int passedTestCases;
    private int failedTestCases;
    private int blockedTestCases;

    public TeamTestingData(String teamName, int totalTestCases, int completedTestCases,
                          int passedTestCases, int failedTestCases, int blockedTestCases) {
        this.teamName = teamName;
        this.totalTestCases = totalTestCases;
        this.completedTestCases = completedTestCases;
        this.passedTestCases = passedTestCases;
        this.failedTestCases = failedTestCases;
        this.blockedTestCases = blockedTestCases;
    }
} 