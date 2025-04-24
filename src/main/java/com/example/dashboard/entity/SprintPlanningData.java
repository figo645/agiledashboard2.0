package com.example.dashboard.entity;

import java.util.List;
import java.util.ArrayList;

public class SprintPlanningData {
    private List<TeamData> teams;

    public SprintPlanningData() {
        this.teams = new ArrayList<>();
    }

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