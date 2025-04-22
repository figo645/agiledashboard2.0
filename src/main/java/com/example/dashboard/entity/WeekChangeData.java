package com.example.dashboard.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeekChangeData {
    private int week;
    private int insertedTasks;
    private int removedTasks;
    private int originalTasks;
    private int teamAChanges;
    private int teamBChanges;
} 