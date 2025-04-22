package com.example.dashboard.entity;

import java.util.List;

public class SprintPlanningData {
    private List<TeamData> teams;

    public SprintPlanningData(List<TeamData> teams) {
        this.teams = teams;
    }

    public List<TeamData> getTeams() {
        return teams;
    }

    public void setTeams(List<TeamData> teams) {
        this.teams = teams;
    }
} 