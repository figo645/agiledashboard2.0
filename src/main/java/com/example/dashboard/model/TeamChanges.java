package com.example.dashboard.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class TeamChanges {
    private String teamName;
    private List<Integer> newTasks;
    private List<Integer> modifiedTasks;
    private List<Integer> removedTasks;
} 