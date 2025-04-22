package com.example.dashboard.service;

import com.example.dashboard.entity.SprintPlanningData;
import com.example.dashboard.entity.TeamData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SprintPlanningService {
    public SprintPlanningData getSprintPlanningData() {
        List<TeamData> teams = new ArrayList<>();
        
        TeamData teamA = new TeamData();
        teamA.setTeamName("团队A");
        teamA.setTeamSize(5);
        teamA.setTotalPoints(100);
        teamA.setPointsPerPerson(20);
        teamA.setDevelopmentPercentage(30);
        teamA.setTestingPercentage(40);
        teamA.setDocumentationPercentage(20);
        teamA.setTestingRate(10);
        teamA.setDelayCards(25);
        teams.add(teamA);

        TeamData teamB = new TeamData();
        teamB.setTeamName("团队B");
        teamB.setTeamSize(6);
        teamB.setTotalPoints(120);
        teamB.setPointsPerPerson(20);
        teamB.setDevelopmentPercentage(35);
        teamB.setTestingPercentage(35);
        teamB.setDocumentationPercentage(20);
        teamB.setTestingRate(10);
        teamB.setDelayCards(30);
        teams.add(teamB);

        TeamData teamC = new TeamData();
        teamC.setTeamName("团队C");
        teamC.setTeamSize(7);
        teamC.setTotalPoints(140);
        teamC.setPointsPerPerson(20);
        teamC.setDevelopmentPercentage(40);
        teamC.setTestingPercentage(30);
        teamC.setDocumentationPercentage(20);
        teamC.setTestingRate(10);
        teamC.setDelayCards(35);
        teams.add(teamC);

        TeamData teamD = new TeamData();
        teamD.setTeamName("团队D");
        teamD.setTeamSize(8);
        teamD.setTotalPoints(160);
        teamD.setPointsPerPerson(20);
        teamD.setDevelopmentPercentage(45);
        teamD.setTestingPercentage(25);
        teamD.setDocumentationPercentage(20);
        teamD.setTestingRate(10);
        teamD.setDelayCards(40);
        teams.add(teamD);

        TeamData teamE = new TeamData();
        teamE.setTeamName("团队E");
        teamE.setTeamSize(9);
        teamE.setTotalPoints(180);
        teamE.setPointsPerPerson(20);
        teamE.setDevelopmentPercentage(50);
        teamE.setTestingPercentage(20);
        teamE.setDocumentationPercentage(20);
        teamE.setTestingRate(10);
        teamE.setDelayCards(45);
        teams.add(teamE);

        return new SprintPlanningData(teams);
    }
} 