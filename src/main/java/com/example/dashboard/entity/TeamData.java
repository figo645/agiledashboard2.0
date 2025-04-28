package com.example.dashboard.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "team_data")
public class TeamData {
    @Id
    private String id;

    @Column(name = "team_name")
    private String teamName;

    @Column(name = "sprint_name")
    private String sprintName;

    @Column(name = "start_date")
    private String startDate;

    @Column(name = "end_date")
    private String endDate;

    @Column(name = "total_stories")
    private Integer totalStories;

    @Column(name = "completed_stories")
    private Integer completedStories;

    @Column(name = "story_completion_rate")
    private Double storyCompletionRate;

    @Column(name = "total_points")
    private Integer totalPoints;

    @Column(name = "completed_points")
    private Integer completedPoints;

    @Column(name = "point_completion_rate")
    private Double pointCompletionRate;

    @Column(name = "total_tasks")
    private Integer totalTasks;

    @Column(name = "completed_tasks")
    private Integer completedTasks;

    @Column(name = "task_completion_rate")
    private Double taskCompletionRate;

    @Column(name = "total_bugs")
    private Integer totalBugs;

    @Column(name = "fixed_bugs")
    private Integer fixedBugs;

    @Column(name = "bug_fix_rate")
    private Double bugFixRate;

    @Column(name = "total_test_cases")
    private Integer totalTestCases;

    @Column(name = "passed_test_cases")
    private Integer passedTestCases;

    @Column(name = "test_pass_rate")
    private Double testPassRate;

    @Column(name = "total_changes")
    private Integer totalChanges;

    @Column(name = "planned_changes")
    private Integer plannedChanges;

    @Column(name = "unplanned_changes")
    private Integer unplannedChanges;

    @Column(name = "change_rate")
    private Double changeRate;

    @Column(name = "program_name")
    private String programName;

    @Column(name = "planned_progress")
    private Double plannedProgress;  // 计划进度

    @Column(name = "actual_progress")
    private Double actualProgress;   // 实际进度

    @Column(name = "planned_count")
    private Double plannedCount;     // 计划需求数

    @Column(name = "completed_count")
    private Double completedCount;   // 完成需求数

    @Column(name = "storypoint_planned")
    private Double storypointPlanned;

    @Column(name = "storypoint_completed")
    private Double storypointCompleted;

    @Column(name = "test_points")
    private Double testPoints;       // 测试故事点

    @Column(name = "user_story_points")
    private Double userStoryPoints;  // 用户故事点

    @Column(name = "user_story_ratio")
    private Double userStoryRatio;   // 用户故事占比

    @Column(name = "enabler_points")
    private Double enablerPoints;    // 技术需求数

    @Column(name = "enabler_ratio")
    private Double enablerRatio;     // 技术需求占比

    @Column(name = "story_throughput")
    private Double storyThroughput;  // 百人天故事吞吐量

    @Column(name = "cv_value")
    private Double cvValue;          // CV值（标准差/平均数）

    @Column(name = "story_granularity")
    private Double storyGranularity; // 故事颗粒度平均值

    @Column(name = "data_date")
    private LocalDate dataDate;      // 数据日期

    @Column(name = "data_month")
    private String dataMonth;        // 数据月份

    @Column(name = "data_quarter")
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