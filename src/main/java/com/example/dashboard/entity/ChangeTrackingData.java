package com.example.dashboard.entity;

import java.util.List;

public class ChangeTrackingData {
    private List<TeamChangeData> teams;

    public ChangeTrackingData(List<TeamChangeData> teams) {
        this.teams = teams;
    }

    public List<TeamChangeData> getTeams() {
        return teams;
    }

    public void setTeams(List<TeamChangeData> teams) {
        this.teams = teams;
    }
} 