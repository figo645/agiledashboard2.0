package com.example.dashboard.entity;

import java.util.List;

public class IterationCompletionData {
    private List<TeamProgressData> teams;

    public IterationCompletionData(List<TeamProgressData> teams) {
        this.teams = teams;
    }

    public List<TeamProgressData> getTeams() {
        return teams;
    }

    public void setTeams(List<TeamProgressData> teams) {
        this.teams = teams;
    }
} 