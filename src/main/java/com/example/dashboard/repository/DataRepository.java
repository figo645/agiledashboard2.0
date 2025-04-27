package com.example.dashboard.repository;

import com.example.dashboard.entity.TeamData;
import com.example.dashboard.entity.IterationCompletion;
import com.example.dashboard.entity.Bug;
import com.example.dashboard.entity.Change;
import com.example.dashboard.entity.Testing;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Qualifier("dataRepository")
public interface DataRepository {
    List<TeamData> getSprintPlanningData();
    List<IterationCompletion> getIterationCompletionData();
    List<Bug> getBugData();
    List<Change> getChangeData();
    List<Testing> getTestingData();
} 