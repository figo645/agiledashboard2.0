package com.example.dashboard.service;

import com.example.dashboard.entity.BugProgressData;
import com.example.dashboard.entity.TeamBugData;
import com.example.dashboard.util.CsvReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BugProgressService {
    @Autowired
    private CsvReader csvReader;

    public BugProgressData getBugProgressData() {
        List<TeamBugData> teams = new ArrayList<>();
        List<String[]> data = csvReader.readCsv("data/bug_progress.csv");
        
        // 跳过标题行
        for (int i = 1; i < data.size(); i++) {
            String[] row = data.get(i);
            teams.add(new TeamBugData(
                row[0], // teamName
                Integer.parseInt(row[1]), // prePending
                Integer.parseInt(row[2]), // preFixed
                Integer.parseInt(row[3]), // uatPending
                Integer.parseInt(row[4])  // uatFixed
            ));
        }
        return new BugProgressData(teams);
    }
} 