package com.example.dashboard.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "iteration_completion")
public class IterationCompletion {
    @Id
    private String id;
    
    @Column(name = "program_name")
    private String programName;
    
    @Column(name = "team_name")
    private String teamName;
    
    @Column(name = "planned_progress")
    private double plannedProgress;
    
    @Column(name = "actual_progress")
    private double actualProgress;
    
    @Column(name = "storypoint_planned")
    private double storypointPlanned;
    
    @Column(name = "storypoint_completed")
    private double storypointCompleted;
    
    @Column(name = "data_date")
    private LocalDate dataDate;
    
    @Column(name = "data_month")
    private String dataMonth;
    
    @Column(name = "data_quarter")
    private String dataQuarter;
} 