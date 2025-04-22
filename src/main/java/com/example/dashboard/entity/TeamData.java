package com.example.dashboard.entity;

public class TeamData {
    private String teamName;
    private int teamSize;
    private int totalPoints;
    private int pointsPerPerson;
    private int storyPercentage;
    private int technicalTaskPercentage;
    private int optimizationPercentage;
    private int testingPercentage;
    private int firstWeekTestingRate;
    private int devDelayCards;
    private int testDelayCards;

    // Getters and Setters
    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    public int getPointsPerPerson() {
        return pointsPerPerson;
    }

    public void setPointsPerPerson(int pointsPerPerson) {
        this.pointsPerPerson = pointsPerPerson;
    }

    public int getStoryPercentage() {
        return storyPercentage;
    }

    public void setStoryPercentage(int storyPercentage) {
        this.storyPercentage = storyPercentage;
    }

    public int getTechnicalTaskPercentage() {
        return technicalTaskPercentage;
    }

    public void setTechnicalTaskPercentage(int technicalTaskPercentage) {
        this.technicalTaskPercentage = technicalTaskPercentage;
    }

    public int getOptimizationPercentage() {
        return optimizationPercentage;
    }

    public void setOptimizationPercentage(int optimizationPercentage) {
        this.optimizationPercentage = optimizationPercentage;
    }

    public int getTestingPercentage() {
        return testingPercentage;
    }

    public void setTestingPercentage(int testingPercentage) {
        this.testingPercentage = testingPercentage;
    }

    public int getFirstWeekTestingRate() {
        return firstWeekTestingRate;
    }

    public void setFirstWeekTestingRate(int firstWeekTestingRate) {
        this.firstWeekTestingRate = firstWeekTestingRate;
    }

    public int getDevDelayCards() {
        return devDelayCards;
    }

    public void setDevDelayCards(int devDelayCards) {
        this.devDelayCards = devDelayCards;
    }

    public int getTestDelayCards() {
        return testDelayCards;
    }

    public void setTestDelayCards(int testDelayCards) {
        this.testDelayCards = testDelayCards;
    }
} 