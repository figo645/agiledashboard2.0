package com.example.dashboard.repository;

import com.example.dashboard.entity.TeamData;
import com.example.dashboard.entity.IterationCompletion;
import com.example.dashboard.entity.Bug;
import com.example.dashboard.entity.Change;
import com.example.dashboard.entity.Testing;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.ClassPathResource;

import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
@Qualifier("csvDataRepository")
public class CsvDataRepository implements DataRepository {
    @Value("${csv.sprint-planning}")
    private String sprintPlanningFile;

    @Value("${csv.iteration-completion}")
    private String iterationCompletionFile;

    @Value("${csv.bug}")
    private String bugFile;

    @Value("${csv.change}")
    private String changeFile;

    @Value("${csv.testing}")
    private String testingFile;

    @Override
    public List<TeamData> getSprintPlanningData() {
        return readCsvFile(sprintPlanningFile, this::mapToTeamData);
    }

    @Override
    public List<IterationCompletion> getIterationCompletionData() {
        return readCsvFile(iterationCompletionFile, this::mapToIterationCompletion);
    }

    @Override
    public List<Bug> getBugData() {
        return readCsvFile(bugFile, this::mapToBug);
    }

    @Override
    public List<Change> getChangeData() {
        return readCsvFile(changeFile, this::mapToChange);
    }

    @Override
    public List<Testing> getTestingData() {
        return readCsvFile(testingFile, this::mapToTesting);
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

    private Bug mapToBug(String[] values) {
        Bug bug = new Bug();
        bug.setId(values[0] + "_" + values[1]);  // programName_teamName as ID
        bug.setProgramName(values[0]);
        bug.setTeamName(values[1]);
        bug.setTotalBugs(Integer.parseInt(values[2]));
        bug.setPreFixed(Integer.parseInt(values[3]));
        bug.setUatFixed(Integer.parseInt(values[4]));
        bug.setPrePending(Integer.parseInt(values[5]));
        bug.setUatPending(Integer.parseInt(values[6]));
        bug.setPreFixedRatio(Double.parseDouble(values[7]));
        bug.setUatFixedRatio(Double.parseDouble(values[8]));
        return bug;
    }

    private Change mapToChange(String[] values) {
        Change change = new Change();
        change.setId(values[0] + "_" + values[1]);  // teamName_issueKey as ID
        change.setTeamName(values[0]);
        change.setIssueKey(values[1]);
        change.setSummary(values[2]);
        change.setStatus(values[3]);
        change.setChangeType(values[4]);
        change.setAssignee(values[5]);
        change.setCreatedDate(values[6]);
        change.setResolvedDate(values[7]);
        change.setStoryPoints(Double.parseDouble(values[8]));
        change.setChangeTasks(Integer.parseInt(values[9]));
        change.setChangePoints(Integer.parseInt(values[10]));
        return change;
    }

    private Testing mapToTesting(String[] values) {
        Testing testing = new Testing();
        testing.setId(values[0] + "_" + values[1]);  // teamName_issueKey as ID
        testing.setTeamName(values[0]);
        testing.setTotalTestCases(Integer.parseInt(values[1]));
        testing.setCompletedTestCases(Integer.parseInt(values[2]));
        testing.setFailedTestCases(Integer.parseInt(values[3]));
        testing.setBlockedTestCases(Integer.parseInt(values[4]));
        return testing;
    }
} 