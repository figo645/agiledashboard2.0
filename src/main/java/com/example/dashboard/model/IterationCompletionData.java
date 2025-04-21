package com.example.dashboard.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class IterationCompletionData {
    private List<String> labels;
    private List<Integer> planned;
    private List<Integer> actual;
    private List<TeamProgress> teams;
} 