package com.example.dashboard.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
} 