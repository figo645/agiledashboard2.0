package com.example.dashboard.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class TeamBugProgress {
    private String teamName;
    private List<Integer> newBugs;
    private List<Integer> fixedBugs;
    private List<Integer> remainingBugs;
    private BugSeverity bugSeverity;
} 