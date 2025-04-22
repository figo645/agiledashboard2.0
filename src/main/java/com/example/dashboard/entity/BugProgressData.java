package com.example.dashboard.entity;

import lombok.Data;
import java.util.List;

@Data
public class BugProgressData {
    private List<TeamBugData> teams;

    public BugProgressData(List<TeamBugData> teams) {
        this.teams = teams;
    }
} 