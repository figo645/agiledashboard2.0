package com.example.dashboard.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "sprint_planning")
public class TeamData {
    @Id
    private String id;
    private String programName;
    private String teamName;
    private double plannedProgress;  // 计划进度
    private double actualProgress;   // 实际进度
    private double plannedCount;     // 计划需求数
    private double completedCount;   // 完成需求数
    private double storypointPlanned;
    private double storypointCompleted;
    private double testPoints;       // 测试故事点
    private double userStoryPoints;  // 用户故事点
    private double userStoryRatio;   // 用户故事占比
    private double enablerPoints;    // 技术需求数
    private double enablerRatio;     // 技术需求占比
    private double storyThroughput;  // 百人天故事吞吐量
    private double cvValue;          // CV值（标准差/平均数）
    private double storyGranularity; // 故事颗粒度平均值
    private LocalDate dataDate;      // 数据日期
    private String dataMonth;        // 数据月份
    private String dataQuarter;      // 数据季度

    // Getters and setters
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

    public double getCvValue() {
        return cvValue;
    }

    public void setCvValue(double cvValue) {
        this.cvValue = cvValue;
    }

    public double getStoryGranularity() {
        return storyGranularity;
    }

    public void setStoryGranularity(double storyGranularity) {
        this.storyGranularity = storyGranularity;
    }
} 