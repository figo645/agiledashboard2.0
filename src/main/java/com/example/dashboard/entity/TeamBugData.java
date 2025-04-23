package com.example.dashboard.entity;

public class TeamBugData {
    private String teamName;
    private int prePending;
    private int preFixed;
    private int uatPending;
    private int uatFixed;

    public TeamBugData(String teamName, int prePending, int preFixed,
                      int uatPending, int uatFixed) {
        this.teamName = teamName;
        this.prePending = prePending;
        this.preFixed = preFixed;
        this.uatPending = uatPending;
        this.uatFixed = uatFixed;
    }

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
} 