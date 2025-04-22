package com.example.dashboard.entity;

import java.util.List;

public class TestingProgressData {
    private List<TestingTeamData> teams;

    public TestingProgressData(List<TestingTeamData> teams) {
        this.teams = teams;
    }

    public List<TestingTeamData> getTeams() {
        return teams;
    }

    public void setTeams(List<TestingTeamData> teams) {
        this.teams = teams;
    }
} 