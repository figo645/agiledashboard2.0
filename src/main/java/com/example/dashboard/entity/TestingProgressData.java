package com.example.dashboard.entity;

import lombok.Data;
import java.util.List;

@Data
public class TestingProgressData {
    private List<TeamTestingData> teams;

    public TestingProgressData(List<TeamTestingData> teams) {
        this.teams = teams;
    }
} 