package com.example.dashboard.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "iteration_completion")
public class IterationCompletion {
    @Id
    @Column(name = "id")
    private String id;
    
    @Column(name = "program_name")
    private String programName;
    
    @Column(name = "team_name")
    private String teamName;
    
    @Column(name = "planned_progress")
    private Double plannedProgress;
    
    @Column(name = "actual_progress")
    private Double actualProgress;
    
    @Column(name = "storypoint_planned")
    private Double storypointPlanned;
    
    @Column(name = "storypoint_completed")
    private Double storypointCompleted;
    
    @Column(name = "data_date")
    private LocalDate dataDate;
    
    @Column(name = "data_month")
    private String dataMonth;
    
    @Column(name = "data_quarter")
    private String dataQuarter;
} 