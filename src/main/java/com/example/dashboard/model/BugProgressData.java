package com.example.dashboard.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class BugProgressData {
    private List<String> labels;
    private List<Integer> newBugs;
    private List<Integer> fixedBugs;
    private List<Integer> remainingBugs;
    private BugSeverity bugSeverity;
    private List<TeamBugProgress> teams;
} 