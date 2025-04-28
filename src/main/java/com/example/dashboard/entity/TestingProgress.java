package com.example.dashboard.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "testing_progress")
public class TestingProgress {
    @Id
    private String id;
    
    @Column(name = "team_name")
    private String teamName;
    
    @Column(name = "total_test_cases")
    private int totalTestCases;
    
    @Column(name = "completed_test_cases")
    private int completedTestCases;
    
    @Column(name = "failed_test_cases")
    private int failedTestCases;
    
    @Column(name = "blocked_test_cases")
    private int blockedTestCases;
    
    @Column(name = "data_date")
    private LocalDate dataDate;
    
    @Column(name = "data_month")
    private String dataMonth;
    
    @Column(name = "data_quarter")
    private String dataQuarter;
} 