package com.example.dashboard.service;

import com.example.dashboard.model.*;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class SprintService {
    
    public SprintData getSprintData() {
        SprintData data = new SprintData();
        
        // 设置团队数据
        data.setTeams(Arrays.asList(
            createTeam("团队A", 5, 50, 10, 60, 20, 10, 10, 80, 2, 1),
            createTeam("团队B", 6, 60, 10, 70, 15, 5, 10, 85, 1, 0),
            createTeam("团队C", 4, 40, 10, 65, 20, 5, 10, 75, 3, 2)
        ));
        
        // 设置周数据
        data.setWeeks(Arrays.asList(
            createWeek(1, 25, 20, 30, 25, 20, 15),
            createWeek(2, 50, 45, 60, 50, 40, 40),
            createWeek(3, 75, 70, 80, 75, 70, 65),
            createWeek(4, 100, 95, 100, 95, 100, 95)
        ));
        
        // 设置变更数据
        data.setChanges(Arrays.asList(
            createChange(1, 5, 3, 2),
            createChange(2, 8, 4, 3),
            createChange(3, 6, 5, 2),
            createChange(4, 4, 3, 1)
        ));
        
        // 设置测试数据
        data.setTesting(Arrays.asList(
            createTesting(1, 30, 25, 100, 80, 20),
            createTesting(2, 60, 55, 150, 120, 30),
            createTesting(3, 90, 85, 200, 160, 40),
            createTesting(4, 100, 95, 250, 200, 50)
        ));
        
        // 设置Bug数据
        data.setBugs(Arrays.asList(
            createBug(1, 10, 5, 5, 2, 3, 5),
            createBug(2, 15, 10, 10, 3, 4, 8),
            createBug(3, 20, 15, 15, 4, 5, 11),
            createBug(4, 25, 20, 20, 5, 6, 14)
        ));
        
        return data;
    }
    
    private TeamData createTeam(String name, int size, int totalPoints, int pointsPerPerson,
                              int storyPercentage, int technicalTaskPercentage,
                              int optimizationPercentage, int testingPercentage,
                              int firstWeekTestingRate, int devDelayCards, int testDelayCards) {
        TeamData team = new TeamData();
        team.setTeamName(name);
        team.setTeamSize(size);
        team.setTotalPoints(totalPoints);
        team.setPointsPerPerson(pointsPerPerson);
        team.setStoryPercentage(storyPercentage);
        team.setTechnicalTaskPercentage(technicalTaskPercentage);
        team.setOptimizationPercentage(optimizationPercentage);
        team.setTestingPercentage(testingPercentage);
        team.setFirstWeekTestingRate(firstWeekTestingRate);
        team.setDevDelayCards(devDelayCards);
        team.setTestDelayCards(testDelayCards);
        return team;
    }
    
    private WeekData createWeek(int week, int plannedProgress, int actualProgress,
                              int teamAPlanned, int teamAActual,
                              int teamBPlanned, int teamBActual) {
        WeekData weekData = new WeekData();
        weekData.setWeek(week);
        weekData.setPlannedProgress(plannedProgress);
        weekData.setActualProgress(actualProgress);
        weekData.setTeamAPlanned(teamAPlanned);
        weekData.setTeamAActual(teamAActual);
        weekData.setTeamBPlanned(teamBPlanned);
        weekData.setTeamBActual(teamBActual);
        return weekData;
    }
    
    private ChangeData createChange(int week, int newTasks, int modifiedTasks, int removedTasks) {
        ChangeData change = new ChangeData();
        change.setWeek(week);
        change.setNewTasks(newTasks);
        change.setModifiedTasks(modifiedTasks);
        change.setRemovedTasks(removedTasks);
        return change;
    }
    
    private TestingData createTesting(int week, int plannedTesting, int actualTesting,
                                    int totalTestCases, int passedTestCases, int failedTestCases) {
        TestingData testing = new TestingData();
        testing.setWeek(week);
        testing.setPlannedTesting(plannedTesting);
        testing.setActualTesting(actualTesting);
        testing.setTotalTestCases(totalTestCases);
        testing.setPassedTestCases(passedTestCases);
        testing.setFailedTestCases(failedTestCases);
        return testing;
    }
    
    private BugData createBug(int week, int newBugs, int fixedBugs, int remainingBugs,
                            int criticalBugs, int majorBugs, int minorBugs) {
        BugData bug = new BugData();
        bug.setWeek(week);
        bug.setNewBugs(newBugs);
        bug.setFixedBugs(fixedBugs);
        bug.setRemainingBugs(remainingBugs);
        bug.setCriticalBugs(criticalBugs);
        bug.setMajorBugs(majorBugs);
        bug.setMinorBugs(minorBugs);
        return bug;
    }
} 