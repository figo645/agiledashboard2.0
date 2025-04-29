package com.example.dashboard.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "bug_progress")
public class BugProgress {
    @Id
    @Column(name = "id")
    private String id;
    
    @Column(name = "program_name")
    private String programName;
    
    @Column(name = "team_name")
    private String teamName;
    
    @Column(name = "total_bugs")
    private Integer totalBugs;
    
    @Column(name = "pre_fixed")
    private Integer preFixed;
    
    @Column(name = "uat_fixed")
    private Integer uatFixed;
    
    @Column(name = "pre_pending")
    private Integer prePending;
    
    @Column(name = "uat_pending")
    private Integer uatPending;
    
    @Column(name = "pre_fixed_ratio")
    private Double preFixedRatio;
    
    @Column(name = "uat_fixed_ratio")
    private Double uatFixedRatio;
    
    @Column(name = "data_date")
    private LocalDate dataDate;
    
    @Column(name = "data_month")
    private String dataMonth;
    
    @Column(name = "data_quarter")
    private String dataQuarter;
} 