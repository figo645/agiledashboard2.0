package com.example.dashboard.repository;

import com.example.dashboard.entity.TeamData;
import com.example.dashboard.entity.IterationCompletion;
import com.example.dashboard.entity.BugProgress;
import com.example.dashboard.entity.ChangeTracking;
import com.example.dashboard.entity.TestingProgress;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.ClassPathResource;

import java.io.InputStreamReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Repository
@Qualifier("csvDataRepository")
public class CsvDataRepository implements DataRepository {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Value("${csv.sprint-planning}")
    private String sprintPlanningFile;

    @Value("${csv.iteration-completion}")
    private String iterationCompletionFile;

    @Value("${csv.bug-progress}")
    private String bugProgressFile;

    @Value("${csv.change-tracking}")
    private String changeTrackingFile;

    @Value("${csv.testing-progress}")
    private String testingProgressFile;

    @Override
    public List<TeamData> getSprintPlanningData() {
        return readCsvFile(sprintPlanningFile, this::mapToTeamData);
    }

    @Override
    public List<IterationCompletion> getIterationCompletionData() {
        return readCsvFile(iterationCompletionFile, this::mapToIterationCompletion);
    }

    @Override
    public List<BugProgress> getBugProgressData() {
        return readCsvFile(bugProgressFile, this::mapToBugProgress);
    }

    @Override
    public List<ChangeTracking> getChangeTrackingData() {
        return readCsvFile(changeTrackingFile, this::mapToChangeTracking);
    }

    @Override
    public List<TestingProgress> getTestingProgressData() {
        return readCsvFile(testingProgressFile, this::mapToTestingProgress);
    }

    private <T> List<T> readCsvFile(String filePath, CsvMapper<T> mapper) {
        List<T> result = new ArrayList<>();
        try {
            ClassPathResource resource = new ClassPathResource(filePath.replace("classpath:", ""));
            try (CSVReader reader = new CSVReader(new InputStreamReader(resource.getInputStream()))) {
                List<String[]> rows = reader.readAll();
                // Skip header row
                for (int i = 1; i < rows.size(); i++) {
                    result.add(mapper.map(rows.get(i)));
                }
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
            System.err.println("Error reading CSV file " + filePath + ": " + e.getMessage());
        }
        return result;
    }

    private interface CsvMapper<T> {
        T map(String[] values);
    }

    private TeamData mapToTeamData(String[] values) {
        TeamData team = new TeamData();
        team.setId(values[0] + "_" + values[1]);  // programName_teamName as ID
        team.setProgramName(values[0]);
        team.setTeamName(values[1]);
        team.setPlannedCount(Double.parseDouble(values[2]));
        team.setCompletedCount(Double.parseDouble(values[3]));
        team.setStorypointPlanned(Double.parseDouble(values[4]));
        team.setStorypointCompleted(Double.parseDouble(values[5]));
        team.setTestPoints(Double.parseDouble(values[6]));
        team.setUserStoryPoints(Double.parseDouble(values[7]));
        team.setUserStoryRatio(Double.parseDouble(values[8]));
        team.setEnablerPoints(Double.parseDouble(values[9]));
        team.setEnablerRatio(Double.parseDouble(values[10]));
        team.setStoryThroughput(Double.parseDouble(values[11]));
        team.setCvValue(Double.parseDouble(values[12]));
        team.setStoryGranularity(Double.parseDouble(values[13]));
        return team;
    }

    private IterationCompletion mapToIterationCompletion(String[] values) {
        IterationCompletion completion = new IterationCompletion();
        completion.setId(values[0] + "_" + values[1]);  // programName_teamName as ID
        completion.setProgramName(values[0]);
        completion.setTeamName(values[1]);
        completion.setPlannedProgress(Double.parseDouble(values[2]));
        completion.setActualProgress(Double.parseDouble(values[3]));
        completion.setStorypointPlanned(Double.parseDouble(values[4]));
        completion.setStorypointCompleted(Double.parseDouble(values[5]));
        return completion;
    }

    private BugProgress mapToBugProgress(String[] values) {
        BugProgress bugProgress = new BugProgress();
        bugProgress.setId(values[0] + "_" + values[1]);  // programName_teamName as ID
        bugProgress.setProgramName(values[0]);
        bugProgress.setTeamName(values[1]);
        bugProgress.setTotalBugs(Integer.parseInt(values[2]));
        bugProgress.setPreFixed(Integer.parseInt(values[3]));
        bugProgress.setUatFixed(Integer.parseInt(values[4]));
        bugProgress.setPrePending(Integer.parseInt(values[5]));
        bugProgress.setUatPending(Integer.parseInt(values[6]));
        bugProgress.setPreFixedRatio(Double.parseDouble(values[7]));
        bugProgress.setUatFixedRatio(Double.parseDouble(values[8]));
        return bugProgress;
    }

    private ChangeTracking mapToChangeTracking(String[] values) {
        ChangeTracking changeTracking = new ChangeTracking();
        changeTracking.setId(values[0]);  // teamName as ID
        changeTracking.setTeamName(values[0]);
        changeTracking.setChangeTasks(Integer.parseInt(values[1]));
        changeTracking.setChangePoints(Integer.parseInt(values[2]));
        return changeTracking;
    }

    private TestingProgress mapToTestingProgress(String[] values) {
        TestingProgress testingProgress = new TestingProgress();
        testingProgress.setId(values[0]);  // teamName as ID
        testingProgress.setTeamName(values[0]);
        testingProgress.setTotalTestCases(Integer.parseInt(values[1]));
        testingProgress.setCompletedTestCases(Integer.parseInt(values[2]));
        testingProgress.setFailedTestCases(Integer.parseInt(values[3]));
        testingProgress.setBlockedTestCases(Integer.parseInt(values[4]));
        return testingProgress;
    }

    private LocalDate parseDate(String dateStr) {
        return LocalDate.parse(dateStr, DATE_FORMATTER);
    }
} 