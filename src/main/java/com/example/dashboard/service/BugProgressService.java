package com.example.dashboard.service;

import com.example.dashboard.entity.BugProgressData;
import com.example.dashboard.entity.TeamBugData;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class BugProgressService {
    private static final Logger logger = LoggerFactory.getLogger(BugProgressService.class);

    public BugProgressData getBugProgressData() {
        List<TeamBugData> teams = new ArrayList<>();
        try {
            logger.info("Starting to read bug progress data");
            ClassPathResource resource = new ClassPathResource("data/bug_progress.csv");
            logger.info("CSV file path: {}", resource.getPath());
            
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()))) {
                String line;
                // Skip header
                reader.readLine();
                int lineCount = 0;
                
                while ((line = reader.readLine()) != null) {
                    lineCount++;
                    logger.debug("Reading line {}: {}", lineCount, line);
                    
                    String[] values = line.split(",");
                    if (values.length < 7) {
                        logger.error("Invalid line format at line {}: {}", lineCount, line);
                        continue;
                    }
                    
                    try {
                        String teamName = values[1].trim();
                        int totalBugs = Integer.parseInt(values[2].trim());
                        int preFixed = Integer.parseInt(values[3].trim());
                        int uatFixed = Integer.parseInt(values[4].trim());
                        int prePending = Integer.parseInt(values[5].trim());
                        int uatPending = Integer.parseInt(values[6].trim());
                        
                        TeamBugData teamData = new TeamBugData(teamName, totalBugs, preFixed, uatFixed, 
                                                             prePending, uatPending, 0.0, 0.0);
                        teams.add(teamData);
                        logger.debug("Added team data: {}", teamData);
                    } catch (NumberFormatException e) {
                        logger.error("Error parsing numbers at line {}: {}", lineCount, line, e);
                    }
                }
                logger.info("Successfully read {} teams from CSV", teams.size());
            }
        } catch (Exception e) {
            logger.error("Error reading bug progress data", e);
        }
        
        BugProgressData result = new BugProgressData(teams);
        logger.info("Returning bug progress data with {} teams", result.getTeams().size());
        return result;
    }
} 