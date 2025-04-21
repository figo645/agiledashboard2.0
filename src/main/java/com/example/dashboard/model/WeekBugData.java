package com.example.dashboard.model;

public class WeekBugData {
    private final int week;
    private final int newBugs;
    private final int fixedBugs;
    private final int remainingBugs;
    private final int criticalBugs;
    private final int majorBugs;
    private final int minorBugs;

    public WeekBugData(int week, int newBugs, int fixedBugs, int remainingBugs,
                      int criticalBugs, int majorBugs, int minorBugs) {
        this.week = week;
        this.newBugs = newBugs;
        this.fixedBugs = fixedBugs;
        this.remainingBugs = remainingBugs;
        this.criticalBugs = criticalBugs;
        this.majorBugs = majorBugs;
        this.minorBugs = minorBugs;
    }

    public int getWeek() {
        return week;
    }

    public int getNewBugs() {
        return newBugs;
    }

    public int getFixedBugs() {
        return fixedBugs;
    }

    public int getRemainingBugs() {
        return remainingBugs;
    }

    public int getCriticalBugs() {
        return criticalBugs;
    }

    public int getMajorBugs() {
        return majorBugs;
    }

    public int getMinorBugs() {
        return minorBugs;
    }
} 