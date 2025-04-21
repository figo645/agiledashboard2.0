package com.example.dashboard.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class TeamTestingProgress {
    private String teamName;
    private List<Integer> actualTesting;
    private TestCaseStats testCaseStats;
} 