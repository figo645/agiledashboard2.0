package com.example.dashboard.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BugSeverity {
    private int critical;
    private int high;
    private int medium;
    private int low;
} 