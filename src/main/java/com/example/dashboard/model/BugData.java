package com.example.dashboard.model;

import lombok.Data;

@Data
public class BugData {
    private int week;
    private int newBugs;
    private int fixedBugs;
    private int remainingBugs;
    private int criticalBugs;
    private int majorBugs;
    private int minorBugs;
} 