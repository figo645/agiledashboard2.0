package com.example.dashboard.entity;

import lombok.Data;
import java.util.List;

@Data
public class SprintPlanningData {
    private List<TeamData> teams;

    public SprintPlanningData(List<TeamData> teams) {
        this.teams = teams;
    }
} 