package com.example.dashboard.entity;

import java.util.List;

public class TestingProgressData {
    private List<TeamTestingData> teams;

    public TestingProgressData(List<TeamTestingData> teams) {
        this.teams = teams;
    }

    public List<TeamTestingData> getTeams() {
        return teams;
    }

    public void setTeams(List<TeamTestingData> teams) {
        this.teams = teams;
    }
} 