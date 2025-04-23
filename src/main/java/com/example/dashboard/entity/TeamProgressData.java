package com.example.dashboard.entity;

public class TeamProgressData {
    private String programName;
    private String teamName;
    private int plannedProgress;
    private int actualProgress;
    private int storypointPlanned;
    private int storypointCompleted;
    private int testPoints;
    private int userStoryPoints;
    private int userStoryRatio;
    private int enablerPoints;
    private int enablerRatio;
    private int storyThroughput;

    public TeamProgressData(String programName, String teamName, int plannedProgress, int actualProgress,
                          int storypointPlanned, int storypointCompleted) {
        this.programName = programName;
        this.teamName = teamName;
        this.plannedProgress = plannedProgress;
        this.actualProgress = actualProgress;
        this.storypointPlanned = storypointPlanned;
        this.storypointCompleted = storypointCompleted;
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

    public int getPlannedProgress() {
        return plannedProgress;
    }

    public void setPlannedProgress(int plannedProgress) {
        this.plannedProgress = plannedProgress;
    }

    public int getActualProgress() {
        return actualProgress;
    }

    public void setActualProgress(int actualProgress) {
        this.actualProgress = actualProgress;
    }

    public int getStorypointPlanned() {
        return storypointPlanned;
    }

    public void setStorypointPlanned(int storypointPlanned) {
        this.storypointPlanned = storypointPlanned;
    }

    public int getStorypointCompleted() {
        return storypointCompleted;
    }

    public void setStorypointCompleted(int storypointCompleted) {
        this.storypointCompleted = storypointCompleted;
    }

    public int getTestPoints() {
        return testPoints;
    }

    public void setTestPoints(int testPoints) {
        this.testPoints = testPoints;
    }

    public int getUserStoryPoints() {
        return userStoryPoints;
    }

    public void setUserStoryPoints(int userStoryPoints) {
        this.userStoryPoints = userStoryPoints;
    }

    public int getUserStoryRatio() {
        return userStoryRatio;
    }

    public void setUserStoryRatio(int userStoryRatio) {
        this.userStoryRatio = userStoryRatio;
    }

    public int getEnablerPoints() {
        return enablerPoints;
    }

    public void setEnablerPoints(int enablerPoints) {
        this.enablerPoints = enablerPoints;
    }

    public int getEnablerRatio() {
        return enablerRatio;
    }

    public void setEnablerRatio(int enablerRatio) {
        this.enablerRatio = enablerRatio;
    }

    public int getStoryThroughput() {
        return storyThroughput;
    }

    public void setStoryThroughput(int storyThroughput) {
        this.storyThroughput = storyThroughput;
    }
} 