package com.example.dashboard.util;

import com.example.dashboard.entity.TeamData;
import com.example.dashboard.entity.IterationCompletion;
import com.example.dashboard.entity.BugProgress;
import com.example.dashboard.entity.ChangeTracking;
import com.example.dashboard.entity.TestingProgress;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class SimpleCsvImporter {
    private static final Logger logger = LoggerFactory.getLogger(SimpleCsvImporter.class);
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void importCsvData(String csvFilePath, String type) throws IOException, CsvValidationException {
        try (CSVReader reader = new CSVReader(new FileReader(csvFilePath))) {
            String[] header = reader.readNext();
            logger.info("CSV header for {}: {}", type, String.join(", ", header));
            
            String[] line;
            int lineNumber = 1;
            while ((line = reader.readNext()) != null) {
                lineNumber++;
                try {
                    switch (type.toLowerCase()) {
                        case "sprint_planning":
                            importSprintPlanningData(line);
                            break;
                        case "iteration_completion":
                            importIterationCompletionData(line);
                            break;
                        case "bug_progress":
                            importBugProgressData(line);
                            break;
                        case "change_tracking":
                            importChangeTrackingData(line);
                            break;
                        case "testing_progress":
                            importTestingProgressData(line);
                            break;
                        default:
                            throw new IllegalArgumentException("Unknown data type: " + type);
                    }
                } catch (Exception e) {
                    logger.error("Error processing line {}: {}", lineNumber, e.getMessage());
                }
            }
        }
    }

    private void importSprintPlanningData(String[] data) {
        TeamData teamData = new TeamData();
        teamData.setId(data[0] + "_" + data[1]);
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
        if (data.length > 14) teamData.setDataDate(parseDate(data[14]));
        if (data.length > 15) teamData.setDataMonth(data[15]);
        if (data.length > 16) teamData.setDataQuarter(data[16]);
        
        entityManager.persist(teamData);
    }

    private void importIterationCompletionData(String[] data) {
        IterationCompletion completion = new IterationCompletion();
        completion.setId(data[0] + "_" + data[1]);
        completion.setProgramName(data[0]);
        completion.setTeamName(data[1]);
        completion.setPlannedProgress(Double.parseDouble(data[2]));
        completion.setActualProgress(Double.parseDouble(data[3]));
        completion.setStorypointPlanned(Double.parseDouble(data[4]));
        completion.setStorypointCompleted(Double.parseDouble(data[5]));
        if (data.length > 6) completion.setDataDate(parseDate(data[6]));
        if (data.length > 7) completion.setDataMonth(data[7]);
        if (data.length > 8) completion.setDataQuarter(data[8]);
        
        entityManager.persist(completion);
    }

    private void importBugProgressData(String[] data) {
        BugProgress bugProgress = new BugProgress();
        bugProgress.setId(data[0] + "_" + data[1]);
        bugProgress.setProgramName(data[0]);
        bugProgress.setTeamName(data[1]);
        bugProgress.setTotalBugs(Integer.parseInt(data[2]));
        bugProgress.setPreFixed(Integer.parseInt(data[3]));
        bugProgress.setUatFixed(Integer.parseInt(data[4]));
        bugProgress.setPrePending(Integer.parseInt(data[5]));
        bugProgress.setUatPending(Integer.parseInt(data[6]));
        bugProgress.setPreFixedRatio(Double.parseDouble(data[7]));
        bugProgress.setUatFixedRatio(Double.parseDouble(data[8]));
        if (data.length > 9) bugProgress.setDataDate(parseDate(data[9]));
        if (data.length > 10) bugProgress.setDataMonth(data[10]);
        if (data.length > 11) bugProgress.setDataQuarter(data[11]);
        
        entityManager.persist(bugProgress);
    }

    private void importChangeTrackingData(String[] data) {
        ChangeTracking changeTracking = new ChangeTracking();
        changeTracking.setId(data[0] + "_" + data[1]);
        changeTracking.setTeamName(data[0]);
        changeTracking.setChangeTasks(Integer.parseInt(data[1]));
        changeTracking.setChangePoints(Integer.parseInt(data[2]));
        if (data.length > 3) changeTracking.setDataDate(parseDate(data[3]));
        if (data.length > 4) changeTracking.setDataMonth(data[4]);
        if (data.length > 5) changeTracking.setDataQuarter(data[5]);
        
        entityManager.persist(changeTracking);
    }

    private void importTestingProgressData(String[] data) {
        TestingProgress testingProgress = new TestingProgress();
        testingProgress.setId(data[0] + "_" + data[1]);
        testingProgress.setTeamName(data[0]);
        testingProgress.setTotalTestCases(Integer.parseInt(data[1]));
        testingProgress.setCompletedTestCases(Integer.parseInt(data[2]));
        testingProgress.setFailedTestCases(Integer.parseInt(data[3]));
        testingProgress.setBlockedTestCases(Integer.parseInt(data[4]));
        if (data.length > 5) testingProgress.setDataDate(parseDate(data[5]));
        if (data.length > 6) testingProgress.setDataMonth(data[6]);
        if (data.length > 7) testingProgress.setDataQuarter(data[7]);
        
        entityManager.persist(testingProgress);
    }

    private LocalDate parseDate(String dateStr) {
        return LocalDate.parse(dateStr, DATE_FORMATTER);
    }
} 