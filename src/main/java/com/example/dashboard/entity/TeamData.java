package com.example.dashboard.entity;

public class TeamData {
    private String teamName;
    private int teamSize;
    private int totalPoints;
    private double pointsPerPerson;
    private int storyPercentage;
    private int technicalPercentage;
    private int optimizationPercentage;
    private int testingPercentage;
    private int firstWeekTestingRate;
    private int devDelayCards;
    private int testDelayCards;

    public TeamData(String teamName, int teamSize, int totalPoints, double pointsPerPerson,
                   int storyPercentage, int technicalPercentage, int optimizationPercentage,
                   int testingPercentage, int firstWeekTestingRate, int devDelayCards,
                   int testDelayCards) {
        this.teamName = teamName;
        this.teamSize = teamSize;
        this.totalPoints = totalPoints;
        this.pointsPerPerson = pointsPerPerson;
        this.storyPercentage = storyPercentage;
        this.technicalPercentage = technicalPercentage;
        this.optimizationPercentage = optimizationPercentage;
        this.testingPercentage = testingPercentage;
        this.firstWeekTestingRate = firstWeekTestingRate;
        this.devDelayCards = devDelayCards;
        this.testDelayCards = testDelayCards;
    }

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

    public double getPointsPerPerson() {
        return pointsPerPerson;
    }

    public void setPointsPerPerson(double pointsPerPerson) {
        this.pointsPerPerson = pointsPerPerson;
    }

    public int getStoryPercentage() {
        return storyPercentage;
    }

    public void setStoryPercentage(int storyPercentage) {
        this.storyPercentage = storyPercentage;
    }

    public int getTechnicalPercentage() {
        return technicalPercentage;
    }

    public void setTechnicalPercentage(int technicalPercentage) {
        this.technicalPercentage = technicalPercentage;
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