package com.example.dashboard.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TestCaseStats {
    private int total;
    private int completed;
    private int passed;
    private int failed;
} 