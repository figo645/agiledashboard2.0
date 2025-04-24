package com.example.dashboard.entity;

public class IssueData {
    private String issueKey;
    private String summary;
    private String status;
    private int points;

    public IssueData() {}

    public IssueData(String issueKey, String summary, String status, int points) {
        this.issueKey = issueKey;
        this.summary = summary;
        this.status = status;
        this.points = points;
    }

    // Getters and Setters
    public String getIssueKey() {
        return issueKey;
    }

    public void setIssueKey(String issueKey) {
        this.issueKey = issueKey;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
} 