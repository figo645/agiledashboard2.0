package com.example.dashboard.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "testing_progress")
public class TestingProgress {
    @Id
    private String id;
    private String teamName;
    private int totalTestCases;
    private int completedTestCases;
    private int failedTestCases;
    private int blockedTestCases;
    private LocalDate dataDate;
    private String dataMonth;
    private String dataQuarter;
} 