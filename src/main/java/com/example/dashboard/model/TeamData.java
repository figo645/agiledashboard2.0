package com.example.dashboard.model;

import lombok.Data;

@Data
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
} 