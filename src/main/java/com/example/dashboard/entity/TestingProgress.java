package com.example.dashboard.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "testing_progress")
public class TestingProgress {
    @Id
    @Column(name = "id")
    private String id;
    
    @Column(name = "team_name")
    private String teamName;
    
    @Column(name = "total_test_cases")
    private Integer totalTestCases;
    
    @Column(name = "completed_test_cases")
    private Integer completedTestCases;
    
    @Column(name = "failed_test_cases")
    private Integer failedTestCases;
    
    @Column(name = "blocked_test_cases")
    private Integer blockedTestCases;
    
    @Column(name = "data_date")
    private LocalDate dataDate;
    
    @Column(name = "data_month")
    private String dataMonth;
    
    @Column(name = "data_quarter")
    private String dataQuarter;
} 