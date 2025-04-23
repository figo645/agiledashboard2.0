package com.example.dashboard.entity;

public class TeamBugData {
    private String teamName;
    private int totalBugs;
    private int preFixed;
    private int uatFixed;
    private int prePending;
    private int uatPending;
    private double preFixedRatio;
    private double uatFixedRatio;

    public TeamBugData(String teamName, int totalBugs, int preFixed, int uatFixed, 
                      int prePending, int uatPending, double preFixedRatio, double uatFixedRatio) {
        this.teamName = teamName;
        this.totalBugs = totalBugs;
        this.preFixed = preFixed;
        this.uatFixed = uatFixed;
        this.prePending = prePending;
        this.uatPending = uatPending;
        this.preFixedRatio = preFixedRatio;
        this.uatFixedRatio = uatFixedRatio;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getTotalBugs() {
        return totalBugs;
    }

    public void setTotalBugs(int totalBugs) {
        this.totalBugs = totalBugs;
    }

    public int getPreFixed() {
        return preFixed;
    }

    public void setPreFixed(int preFixed) {
        this.preFixed = preFixed;
    }

    public int getUatFixed() {
        return uatFixed;
    }

    public void setUatFixed(int uatFixed) {
        this.uatFixed = uatFixed;
    }

    public int getPrePending() {
        return prePending;
    }

    public void setPrePending(int prePending) {
        this.prePending = prePending;
    }

    public int getUatPending() {
        return uatPending;
    }

    public void setUatPending(int uatPending) {
        this.uatPending = uatPending;
    }

    public double getPreFixedRatio() {
        return preFixedRatio;
    }

    public void setPreFixedRatio(double preFixedRatio) {
        this.preFixedRatio = preFixedRatio;
    }

    public double getUatFixedRatio() {
        return uatFixedRatio;
    }

    public void setUatFixedRatio(double uatFixedRatio) {
        this.uatFixedRatio = uatFixedRatio;
    }

    @Override
    public String toString() {
        return "TeamBugData{" +
                "teamName='" + teamName + '\'' +
                ", totalBugs=" + totalBugs +
                ", preFixed=" + preFixed +
                ", uatFixed=" + uatFixed +
                ", prePending=" + prePending +
                ", uatPending=" + uatPending +
                '}';
    }
} 