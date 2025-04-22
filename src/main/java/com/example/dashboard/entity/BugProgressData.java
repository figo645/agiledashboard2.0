package com.example.dashboard.entity;

import java.util.List;

public class BugProgressData {
    private List<BugTeamData> teams;

    public BugProgressData(List<BugTeamData> teams) {
        this.teams = teams;
    }

    public List<BugTeamData> getTeams() {
        return teams;
    }

    public void setTeams(List<BugTeamData> teams) {
        this.teams = teams;
    }
} 