package com.example.dashboard.util;

import com.example.dashboard.entity.TeamData;
import com.example.dashboard.entity.IterationCompletion;
import com.example.dashboard.entity.BugProgress;
import com.example.dashboard.entity.ChangeTracking;
import com.example.dashboard.entity.TestingProgress;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Component
public class CsvToPostgresImporter {
    @PersistenceContext
    private EntityManager entityManager;

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Transactional
    public void importData(String[] data, String type) {
        switch (type.toLowerCase()) {
            case "sprint_planning":
                importSprintPlanningData(data);
                break;
            case "iteration_completion":
                importIterationCompletionData(data);
                break;
            case "bug_progress":
                importBugProgressData(data);
                break;
            case "change_tracking":
                importChangeTrackingData(data);
                break;
            case "testing_progress":
                importTestingProgressData(data);
                break;
            default:
                throw new IllegalArgumentException("Unknown data type: " + type);
        }
    }

    private void importSprintPlanningData(String[] data) {
        TeamData teamData = new TeamData();
        teamData.setId(UUID.randomUUID().toString());
        teamData.setProgramName(data[0]);
        teamData.setTeamName(data[1]);
        teamData.setPlannedCount(Double.parseDouble(data[2]));
        teamData.setCompletedCount(Double.parseDouble(data[3]));
        teamData.setStorypointPlanned(Double.parseDouble(data[4]));
        teamData.setStorypointCompleted(Double.parseDouble(data[5]));
        teamData.setTestPoints(Double.parseDouble(data[6]));
        teamData.setUserStoryPoints(Double.parseDouble(data[7]));
        teamData.setUserStoryRatio(Double.parseDouble(data[8]));
        teamData.setEnablerPoints(Double.parseDouble(data[9]));
        teamData.setEnablerRatio(Double.parseDouble(data[10]));
        teamData.setStoryThroughput(Double.parseDouble(data[11]));
        teamData.setCvValue(Double.parseDouble(data[12]));
        teamData.setStoryGranularity(Double.parseDouble(data[13]));
        teamData.setDataDate(parseDate(data[14]));
        teamData.setDataMonth(data[15]);
        teamData.setDataQuarter(data[16]);
        
        entityManager.persist(teamData);
    }

    private void importIterationCompletionData(String[] data) {
        IterationCompletion completion = new IterationCompletion();
        completion.setId(UUID.randomUUID().toString());
        completion.setProgramName(data[0]);
        completion.setTeamName(data[1]);
        completion.setPlannedProgress(Double.parseDouble(data[2]));
        completion.setActualProgress(Double.parseDouble(data[3]));
        completion.setStorypointPlanned(Double.parseDouble(data[4]));
        completion.setStorypointCompleted(Double.parseDouble(data[5]));
        completion.setDataDate(parseDate(data[6]));
        completion.setDataMonth(data[7]);
        completion.setDataQuarter(data[8]);
        
        entityManager.persist(completion);
    }

    private void importBugProgressData(String[] data) {
        BugProgress bugProgress = new BugProgress();
        bugProgress.setId(UUID.randomUUID().toString());
        bugProgress.setProgramName(data[0]);
        bugProgress.setTeamName(data[1]);
        bugProgress.setTotalBugs(Integer.parseInt(data[2]));
        bugProgress.setPreFixed(Integer.parseInt(data[3]));
        bugProgress.setUatFixed(Integer.parseInt(data[4]));
        bugProgress.setPrePending(Integer.parseInt(data[5]));
        bugProgress.setUatPending(Integer.parseInt(data[6]));
        bugProgress.setPreFixedRatio(Double.parseDouble(data[7]));
        bugProgress.setUatFixedRatio(Double.parseDouble(data[8]));
        bugProgress.setDataDate(parseDate(data[9]));
        bugProgress.setDataMonth(data[10]);
        bugProgress.setDataQuarter(data[11]);
        
        entityManager.persist(bugProgress);
    }

    private void importChangeTrackingData(String[] data) {
        ChangeTracking changeTracking = new ChangeTracking();
        changeTracking.setId(UUID.randomUUID().toString());
        changeTracking.setTeamName(data[0]);
        changeTracking.setChangeTasks(Integer.parseInt(data[1]));
        changeTracking.setChangePoints(Integer.parseInt(data[2]));
        changeTracking.setDataDate(parseDate(data[3]));
        changeTracking.setDataMonth(data[4]);
        changeTracking.setDataQuarter(data[5]);
        
        entityManager.persist(changeTracking);
    }

    private void importTestingProgressData(String[] data) {
        TestingProgress testingProgress = new TestingProgress();
        testingProgress.setId(UUID.randomUUID().toString());
        testingProgress.setTeamName(data[0]);
        testingProgress.setTotalTestCases(Integer.parseInt(data[1]));
        testingProgress.setCompletedTestCases(Integer.parseInt(data[2]));
        testingProgress.setFailedTestCases(Integer.parseInt(data[3]));
        testingProgress.setBlockedTestCases(Integer.parseInt(data[4]));
        testingProgress.setDataDate(parseDate(data[5]));
        testingProgress.setDataMonth(data[6]);
        testingProgress.setDataQuarter(data[7]);
        
        entityManager.persist(testingProgress);
    }

    private LocalDate parseDate(String dateStr) {
        return LocalDate.parse(dateStr, DATE_FORMATTER);
    }
} 