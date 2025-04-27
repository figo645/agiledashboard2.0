package com.example.dashboard.service;

import com.example.dashboard.config.CsvConfig;
import com.example.dashboard.entity.SprintPlanningData;
import com.example.dashboard.entity.TeamData;
import com.example.dashboard.entity.IssueData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

@Service
public class SprintPlanningService {
    private final CsvConfig csvConfig;

    @Autowired
    public SprintPlanningService(CsvConfig csvConfig) {
        this.csvConfig = csvConfig;
    }

    public SprintPlanningData getSprintPlanningData() {
        SprintPlanningData data = new SprintPlanningData();
        List<TeamData> teams = new ArrayList<>();
        
        try {
            ClassPathResource resource = new ClassPathResource("data/" + csvConfig.getSprintFilePath());
            try (BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream()))) {
                String line;
                br.readLine(); // Skip header
                
                while ((line = br.readLine()) != null) {
                    String[] values = line.split(",");
                    if (values.length >= 14) {
                        TeamData team = new TeamData();
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
                        teams.add(team);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        data.setTeams(teams);
        return data;
    }

    private void loadIssueData(TeamData team) {
        try {
            ClassPathResource resource = new ClassPathResource("data/" + csvConfig.getIterationFilePath());
            try (BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream()))) {
                String line;
                br.readLine(); // Skip header
                
                Map<String, List<IssueData>> plannedIssues = new HashMap<>();
                Map<String, List<IssueData>> completedIssues = new HashMap<>();
                Map<String, List<IssueData>> testIssues = new HashMap<>();
                Map<String, List<IssueData>> userStoryIssues = new HashMap<>();
                Map<String, List<IssueData>> enablerIssues = new HashMap<>();
                
                while ((line = br.readLine()) != null) {
                    String[] values = line.split(",");
                    if (values.length >= 6 && values[1].equals(team.getTeamName())) {
                        IssueData issue = new IssueData();
                        issue.setIssueKey(values[2]);
                        issue.setSummary(values[3]);
                        issue.setStatus(values[4]);
                        issue.setPoints((int) Double.parseDouble(values[5]));
                        
                        switch(values[0]) {
                            case "planned":
                                plannedIssues.computeIfAbsent(team.getTeamName(), k -> new ArrayList<>()).add(issue);
                                break;
                            case "completed":
                                completedIssues.computeIfAbsent(team.getTeamName(), k -> new ArrayList<>()).add(issue);
                                break;
                            case "test":
                                testIssues.computeIfAbsent(team.getTeamName(), k -> new ArrayList<>()).add(issue);
                                break;
                            case "userStory":
                                userStoryIssues.computeIfAbsent(team.getTeamName(), k -> new ArrayList<>()).add(issue);
                                break;
                            case "enabler":
                                enablerIssues.computeIfAbsent(team.getTeamName(), k -> new ArrayList<>()).add(issue);
                                break;
                        }
                    }
                }
                
                team.setPlannedIssues(plannedIssues.getOrDefault(team.getTeamName(), new ArrayList<>()));
                team.setCompletedIssues(completedIssues.getOrDefault(team.getTeamName(), new ArrayList<>()));
                team.setTestIssues(testIssues.getOrDefault(team.getTeamName(), new ArrayList<>()));
                team.setUserStoryIssues(userStoryIssues.getOrDefault(team.getTeamName(), new ArrayList<>()));
                team.setEnablerIssues(enablerIssues.getOrDefault(team.getTeamName(), new ArrayList<>()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
} 