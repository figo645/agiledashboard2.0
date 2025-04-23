package com.example.dashboard.entity;

public class TeamData {
    private String teamName;
    private int teamSize;
    private int totalPoints;
    private int pointsPerPerson;
    private int developmentPercentage;
    private int testingPercentage;
    private int documentationPercentage;
    private int testingRate;
    private int delayCards;

    public TeamData(String teamName, int teamSize, int totalPoints, int pointsPerPerson,
                   int developmentPercentage, int testingPercentage, int documentationPercentage,
                   int testingRate, int delayCards) {
        this.teamName = teamName;
        this.teamSize = teamSize;
        this.totalPoints = totalPoints;
        this.pointsPerPerson = pointsPerPerson;
        this.developmentPercentage = developmentPercentage;
        this.testingPercentage = testingPercentage;
        this.documentationPercentage = documentationPercentage;
        this.testingRate = testingRate;
        this.delayCards = delayCards;
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

    public int getPointsPerPerson() {
        return pointsPerPerson;
    }

    public void setPointsPerPerson(int pointsPerPerson) {
        this.pointsPerPerson = pointsPerPerson;
    }

    public int getDevelopmentPercentage() {
        return developmentPercentage;
    }

    public void setDevelopmentPercentage(int developmentPercentage) {
        this.developmentPercentage = developmentPercentage;
    }

    public int getTestingPercentage() {
        return testingPercentage;
    }

    public void setTestingPercentage(int testingPercentage) {
        this.testingPercentage = testingPercentage;
    }

    public int getDocumentationPercentage() {
        return documentationPercentage;
    }

    public void setDocumentationPercentage(int documentationPercentage) {
        this.documentationPercentage = documentationPercentage;
    }

    public int getTestingRate() {
        return testingRate;
    }

    public void setTestingRate(int testingRate) {
        this.testingRate = testingRate;
    }

    public int getDelayCards() {
        return delayCards;
    }

    public void setDelayCards(int delayCards) {
        this.delayCards = delayCards;
    }
} 