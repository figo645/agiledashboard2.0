package com.example.dashboard.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

/**
 * 表示变更跟踪的实体类。
 * 用于记录和跟踪项目中的变更请求和变更状态。
 */
@Data
@Entity
@Table(name = "change_tracking")
public class ChangeTracking {
    @Id
    @Column(name = "id")
    private String id;
    
    @Column(name = "team_name")
    private String teamName;
    
    @Column(name = "change_tasks")
    private Integer changeTasks;
    
    @Column(name = "change_points")
    private Integer changePoints;
    
    @Column(name = "data_date")
    private LocalDate dataDate;
    
    @Column(name = "data_month")
    private String dataMonth;
    
    @Column(name = "data_quarter")
    private String dataQuarter;
} 