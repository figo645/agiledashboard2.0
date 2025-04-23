package com.example.dashboard.entity;

public class TeamData {
    private String programName;
    private String teamName;
    private double plannedCount;
    private double completedCount;
    private double storypointPlanned;
    private double storypointCompleted;
    private double testPoints;
    private double userStoryPoints;
    private double userStoryRatio;
    private double enablerPoints;
    private double enablerRatio;
    private double storyThroughput;

    public TeamData(String programName, String teamName, double plannedCount, double completedCount,
                   double storypointPlanned, double storypointCompleted, double testPoints,
                   double userStoryPoints, double userStoryRatio, double enablerPoints,
                   double enablerRatio, double storyThroughput) {
        this.programName = programName;
        this.teamName = teamName;
        this.plannedCount = plannedCount;
        this.completedCount = completedCount;
        this.storypointPlanned = storypointPlanned;
        this.storypointCompleted = storypointCompleted;
        this.testPoints = testPoints;
        this.userStoryPoints = userStoryPoints;
        this.userStoryRatio = userStoryRatio;
        this.enablerPoints = enablerPoints;
        this.enablerRatio = enablerRatio;
        this.storyThroughput = storyThroughput;
    }

    // Getters and setters
    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public double getPlannedCount() {
        return plannedCount;
    }

    public void setPlannedCount(double plannedCount) {
        this.plannedCount = plannedCount;
    }

    public double getCompletedCount() {
        return completedCount;
    }

    public void setCompletedCount(double completedCount) {
        this.completedCount = completedCount;
    }

    public double getStorypointPlanned() {
        return storypointPlanned;
    }

    public void setStorypointPlanned(double storypointPlanned) {
        this.storypointPlanned = storypointPlanned;
    }

    public double getStorypointCompleted() {
        return storypointCompleted;
    }

    public void setStorypointCompleted(double storypointCompleted) {
        this.storypointCompleted = storypointCompleted;
    }

    public double getTestPoints() {
        return testPoints;
    }

    public void setTestPoints(double testPoints) {
        this.testPoints = testPoints;
    }

    public double getUserStoryPoints() {
        return userStoryPoints;
    }

    public void setUserStoryPoints(double userStoryPoints) {
        this.userStoryPoints = userStoryPoints;
    }

    public double getUserStoryRatio() {
        return userStoryRatio;
    }

    public void setUserStoryRatio(double userStoryRatio) {
        this.userStoryRatio = userStoryRatio;
    }

    public double getEnablerPoints() {
        return enablerPoints;
    }

    public void setEnablerPoints(double enablerPoints) {
        this.enablerPoints = enablerPoints;
    }

    public double getEnablerRatio() {
        return enablerRatio;
    }

    public void setEnablerRatio(double enablerRatio) {
        this.enablerRatio = enablerRatio;
    }

    public double getStoryThroughput() {
        return storyThroughput;
    }

    public void setStoryThroughput(double storyThroughput) {
        this.storyThroughput = storyThroughput;
    }
} 