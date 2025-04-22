package com.example.dashboard.model;

import lombok.Data;

@Data
public class TestingData {
    private int week;
    private int plannedTesting;
    private int actualTesting;
    private int totalTestCases;
    private int passedTestCases;
    private int failedTestCases;
} 