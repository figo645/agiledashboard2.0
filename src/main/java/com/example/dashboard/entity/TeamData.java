package com.example.dashboard.entity;

import java.util.List;
import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeamData {
    private String programName;
    private String teamName;
    private double plannedCount;  // 计划需求数
    private double completedCount;
    private double storypointPlanned;
    private double storypointCompleted;
    private double testPoints;  // 测试故事点
    private double userStoryPoints;
    private double userStoryRatio;
    private double enablerPoints;  // 技术需求数
    private double enablerRatio;  // 技术需求占比
    private double storyThroughput;  // 百人天故事吞吐量

    private List<IssueData> plannedIssues;
    private List<IssueData> completedIssues;
    private List<IssueData> testIssues;
    private List<IssueData> userStoryIssues;
    private List<IssueData> enablerIssues;

    public TeamData() {
        this.plannedIssues = new ArrayList<>();
        this.completedIssues = new ArrayList<>();
        this.testIssues = new ArrayList<>();
        this.userStoryIssues = new ArrayList<>();
        this.enablerIssues = new ArrayList<>();
    }

    public TeamData(String programName, String teamName, double plannedCount, double completedCount,
                   double storypointPlanned, double storypointCompleted, double testPoints,
                   double userStoryPoints, double userStoryRatio, double enablerPoints,
                   double enablerRatio, double storyThroughput) {
        this.programName = programName;
        this.teamName = teamName;
        this.plannedCount = plannedCount;
        this.completedCount = completedCount;
        this.storypointPlanned = storypointPlanned;
        this.storypointCompleted = storypointCompleted;
        this.testPoints = testPoints;
        this.userStoryPoints = userStoryPoints;
        this.userStoryRatio = userStoryRatio;
        this.enablerPoints = enablerPoints;
        this.enablerRatio = enablerRatio;
        this.storyThroughput = storyThroughput;
    }

    // Getters and setters
    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public double getPlannedCount() {
        return plannedCount;
    }

    public void setPlannedCount(double plannedCount) {
        this.plannedCount = plannedCount;
    }

    public double getCompletedCount() {
        return completedCount;
    }

    public void setCompletedCount(double completedCount) {
        this.completedCount = completedCount;
    }

    public double getStorypointPlanned() {
        return storypointPlanned;
    }

    public void setStorypointPlanned(double storypointPlanned) {
        this.storypointPlanned = storypointPlanned;
    }

    public double getStorypointCompleted() {
        return storypointCompleted;
    }

    public void setStorypointCompleted(double storypointCompleted) {
        this.storypointCompleted = storypointCompleted;
    }

    public double getTestPoints() {
        return testPoints;
    }

    public void setTestPoints(double testPoints) {
        this.testPoints = testPoints;
    }

    public double getUserStoryPoints() {
        return userStoryPoints;
    }

    public void setUserStoryPoints(double userStoryPoints) {
        this.userStoryPoints = userStoryPoints;
    }

    public double getUserStoryRatio() {
        return userStoryRatio;
    }

    public void setUserStoryRatio(double userStoryRatio) {
        this.userStoryRatio = userStoryRatio;
    }

    public double getEnablerPoints() {
        return enablerPoints;
    }

    public void setEnablerPoints(double enablerPoints) {
        this.enablerPoints = enablerPoints;
    }

    public double getEnablerRatio() {
        return enablerRatio;
    }

    public void setEnablerRatio(double enablerRatio) {
        this.enablerRatio = enablerRatio;
    }

    public double getStoryThroughput() {
        return storyThroughput;
    }

    public void setStoryThroughput(double storyThroughput) {
        this.storyThroughput = storyThroughput;
    }

    public List<IssueData> getPlannedIssues() {
        return plannedIssues;
    }

    public void setPlannedIssues(List<IssueData> plannedIssues) {
        this.plannedIssues = plannedIssues;
    }

    public List<IssueData> getCompletedIssues() {
        return completedIssues;
    }

    public void setCompletedIssues(List<IssueData> completedIssues) {
        this.completedIssues = completedIssues;
    }

    public List<IssueData> getTestIssues() {
        return testIssues;
    }

    public void setTestIssues(List<IssueData> testIssues) {
        this.testIssues = testIssues;
    }

    public List<IssueData> getUserStoryIssues() {
        return userStoryIssues;
    }

    public void setUserStoryIssues(List<IssueData> userStoryIssues) {
        this.userStoryIssues = userStoryIssues;
    }

    public List<IssueData> getEnablerIssues() {
        return enablerIssues;
    }

    public void setEnablerIssues(List<IssueData> enablerIssues) {
        this.enablerIssues = enablerIssues;
    }
} 