package com.example.dashboard.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class TestingProgressData {
    private List<String> labels;
    private List<Integer> plannedTesting;
    private List<Integer> actualTesting;
    private TestCaseStats testCaseStats;
    private List<TeamTestingProgress> teams;
} 