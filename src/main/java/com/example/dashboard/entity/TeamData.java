package com.example.dashboard.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

/**
 * 表示团队数据的实体类。
 * 用于记录和跟踪团队的基本信息和绩效指标。
 */
@Data
@Entity
@Table(name = "sprint_planning")
public class TeamData {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "program_name")
    private String programName;

    @Column(name = "team_name")
    private String teamName;

    @Column(name = "planned_count")
    private Double plannedCount;

    @Column(name = "completed_count")
    private Double completedCount;

    @Column(name = "storypoint_planned")
    private Double storypointPlanned;

    @Column(name = "storypoint_completed")
    private Double storypointCompleted;

    @Column(name = "test_points")
    private Double testPoints;

    @Column(name = "user_story_points")
    private Double userStoryPoints;

    @Column(name = "user_story_ratio")
    private Double userStoryRatio;

    @Column(name = "enabler_points")
    private Double enablerPoints;

    @Column(name = "enabler_ratio")
    private Double enablerRatio;

    @Column(name = "story_throughput")
    private Double storyThroughput;

    @Column(name = "cv_value")
    private Double cvValue;

    @Column(name = "story_granularity")
    private Double storyGranularity;

    @Column(name = "data_date")
    private LocalDate dataDate;

    @Column(name = "data_month")
    private String dataMonth;

    @Column(name = "data_quarter")
    private String dataQuarter;
} 