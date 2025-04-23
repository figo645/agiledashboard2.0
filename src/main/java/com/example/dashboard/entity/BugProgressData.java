package com.example.dashboard.entity;

import java.util.List;

public class BugProgressData {
    private List<TeamBugData> teams;

    public BugProgressData(List<TeamBugData> teams) {
        this.teams = teams;
    }

    public List<TeamBugData> getTeams() {
        return teams;
    }

    public void setTeams(List<TeamBugData> teams) {
        this.teams = teams;
    }
} 