package com.example.dashboard.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "change_tracking")
public class ChangeTracking {
    @Id
    private String id;
    
    @Column(name = "team_name")
    private String teamName;
    
    @Column(name = "change_tasks")
    private int changeTasks;
    
    @Column(name = "change_points")
    private int changePoints;
    
    @Column(name = "data_date")
    private LocalDate dataDate;
    
    @Column(name = "data_month")
    private String dataMonth;
    
    @Column(name = "data_quarter")
    private String dataQuarter;
} 