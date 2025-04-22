package com.example.dashboard.model;

import lombok.Data;

@Data
public class ChangeData {
    private int week;
    private int newTasks;
    private int modifiedTasks;
    private int removedTasks;
} 