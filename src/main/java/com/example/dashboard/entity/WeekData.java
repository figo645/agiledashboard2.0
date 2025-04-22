package com.example.dashboard.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeekData {
    private int week;
    private int plannedProgress;
    private int actualProgress;
    private int teamAPlanned;
    private int teamAActual;
    private int teamBPlanned;
    private int teamBActual;
} 