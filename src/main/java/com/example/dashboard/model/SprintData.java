package com.example.dashboard.model;

import lombok.Data;
import java.util.List;

@Data
public class SprintData {
    private List<TeamData> teams;
    private List<WeekData> weeks;
    private List<ChangeData> changes;
    private List<TestingData> testing;
    private List<BugData> bugs;
} 