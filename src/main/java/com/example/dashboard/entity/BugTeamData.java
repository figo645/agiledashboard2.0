package com.example.dashboard.entity;

public class BugTeamData {
    private String teamName;
    private int prePending;
    private int preFixed;
    private int uatPending;
    private int uatFixed;
    private int criticalBugs;
    private int majorBugs;
    private int minorBugs;

    public BugTeamData(String teamName, int prePending, int preFixed, int uatPending,
                      int uatFixed, int criticalBugs, int majorBugs, int minorBugs) {
        this.teamName = teamName;
        this.prePending = prePending;
        this.preFixed = preFixed;
        this.uatPending = uatPending;
        this.uatFixed = uatFixed;
        this.criticalBugs = criticalBugs;
        this.majorBugs = majorBugs;
        this.minorBugs = minorBugs;
    }

    // Getters and Setters
    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getPrePending() {
        return prePending;
    }

    public void setPrePending(int prePending) {
        this.prePending = prePending;
    }

    public int getPreFixed() {
        return preFixed;
    }

    public void setPreFixed(int preFixed) {
        this.preFixed = preFixed;
    }

    public int getUatPending() {
        return uatPending;
    }

    public void setUatPending(int uatPending) {
        this.uatPending = uatPending;
    }

    public int getUatFixed() {
        return uatFixed;
    }

    public void setUatFixed(int uatFixed) {
        this.uatFixed = uatFixed;
    }

    public int getCriticalBugs() {
        return criticalBugs;
    }

    public void setCriticalBugs(int criticalBugs) {
        this.criticalBugs = criticalBugs;
    }

    public int getMajorBugs() {
        return majorBugs;
    }

    public void setMajorBugs(int majorBugs) {
        this.majorBugs = majorBugs;
    }

    public int getMinorBugs() {
        return minorBugs;
    }

    public void setMinorBugs(int minorBugs) {
        this.minorBugs = minorBugs;
    }
} 