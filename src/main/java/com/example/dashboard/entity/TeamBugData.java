package com.example.dashboard.entity;

import lombok.Data;

@Data
public class TeamBugData {
    private String teamName;
    private int prePending;
    private int preFixed;
    private int uatPending;
    private int uatFixed;
    private int teamABugs;
    private int teamBBugs;

    public TeamBugData(String teamName, int prePending, int preFixed, int uatPending,
                      int uatFixed, int teamABugs, int teamBBugs) {
        this.teamName = teamName;
        this.prePending = prePending;
        this.preFixed = preFixed;
        this.uatPending = uatPending;
        this.uatFixed = uatFixed;
        this.teamABugs = teamABugs;
        this.teamBBugs = teamBBugs;
    }
} 