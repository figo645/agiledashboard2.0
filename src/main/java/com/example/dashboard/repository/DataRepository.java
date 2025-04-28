package com.example.dashboard.repository;

import com.example.dashboard.entity.TeamData;
import com.example.dashboard.entity.IterationCompletion;
import com.example.dashboard.entity.BugProgress;
import com.example.dashboard.entity.ChangeTracking;
import com.example.dashboard.entity.TestingProgress;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Qualifier("dataRepository")
public interface DataRepository {
    List<TeamData> getSprintPlanningData();
    List<IterationCompletion> getIterationCompletionData();
    List<BugProgress> getBugProgressData();
    List<ChangeTracking> getChangeTrackingData();
    List<TestingProgress> getTestingProgressData();
} 