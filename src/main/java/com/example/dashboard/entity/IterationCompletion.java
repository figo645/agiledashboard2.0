package com.example.dashboard.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "iteration_completion")
public class IterationCompletion {
    @Id
    private String id;
    private String programName;
    private String teamName;
    private double plannedProgress;
    private double actualProgress;
    private double storypointPlanned;
    private double storypointCompleted;
} 