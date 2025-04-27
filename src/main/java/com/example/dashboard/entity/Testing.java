package com.example.dashboard.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "testing")
public class Testing {
    @Id
    private String id;
    private String teamName;
    private String issueKey;
    private String summary;
    private String status;
    private String testType;
    private String assignee;
    private String createdDate;
    private String completedDate;
    private int totalTestCases;
    private int completedTestCases;
    private int failedTestCases;
    private int blockedTestCases;
    private double storyPoints;
} 