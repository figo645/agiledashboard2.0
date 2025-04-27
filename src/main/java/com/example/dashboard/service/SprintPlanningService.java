package com.example.dashboard.service;

import com.example.dashboard.entity.TeamData;
import com.example.dashboard.entity.IterationCompletion;
import com.example.dashboard.entity.Bug;
import com.example.dashboard.entity.Change;
import com.example.dashboard.entity.Testing;
import com.example.dashboard.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.io.FileReader;
import com.opencsv.CSVReader;

@Service
public class SprintPlanningService {

    private final DataRepository dataRepository;
    private final String sprintPlanningCsvPath;

    @Autowired
    public SprintPlanningService(@Value("${use.postgresql}") boolean usePostgresql,
                               @Qualifier("csvDataRepository") DataRepository csvDataRepository,
                               @Qualifier("postgresDataRepository") DataRepository postgresDataRepository,
                               @Value("${csv.sprint-planning}") String sprintPlanningCsvPath) {
        this.dataRepository = usePostgresql ? postgresDataRepository : csvDataRepository;
        this.sprintPlanningCsvPath = sprintPlanningCsvPath;
    }

    public List<TeamData> getSprintPlanningData() {
        if (dataRepository != null) {
            return dataRepository.getSprintPlanningData();
        }
        return readSprintPlanningFromCsv();
    }

    public List<IterationCompletion> getIterationCompletionData() {
        return dataRepository.getIterationCompletionData();
    }

    public List<Bug> getBugData() {
        return dataRepository.getBugData();
    }

    public List<Change> getChangeData() {
        return dataRepository.getChangeData();
    }

    public List<Testing> getTestingData() {
        return dataRepository.getTestingData();
    }

    private List<TeamData> readSprintPlanningFromCsv() {
        List<TeamData> data = new ArrayList<>();
        try {
            ClassPathResource resource = new ClassPathResource(sprintPlanningCsvPath.replace("classpath:", ""));
            try (CSVReader reader = new CSVReader(new InputStreamReader(resource.getInputStream()))) {
                String[] headers = reader.readNext();
                String[] values;
                while ((values = reader.readNext()) != null) {
                    TeamData teamData = new TeamData();
                    teamData.setId(values[0] + "_" + values[1]);
                    teamData.setProgramName(values[0]);
                    teamData.setTeamName(values[1]);
                    teamData.setPlannedCount(Double.parseDouble(values[2]));
                    teamData.setCompletedCount(Double.parseDouble(values[3]));
                    teamData.setStorypointPlanned(Double.parseDouble(values[4]));
                    teamData.setStorypointCompleted(Double.parseDouble(values[5]));
                    teamData.setTestPoints(Double.parseDouble(values[6]));
                    teamData.setUserStoryPoints(Double.parseDouble(values[7]));
                    teamData.setUserStoryRatio(Double.parseDouble(values[8]));
                    teamData.setEnablerPoints(Double.parseDouble(values[9]));
                    teamData.setEnablerRatio(Double.parseDouble(values[10]));
                    teamData.setStoryThroughput(Double.parseDouble(values[11]));
                    teamData.setCvValue(Double.parseDouble(values[12]));
                    teamData.setStoryGranularity(Double.parseDouble(values[13]));
                    data.add(teamData);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error reading CSV file: " + e.getMessage());
        }
        return data;
    }
} 