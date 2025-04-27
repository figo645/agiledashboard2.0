package com.example.dashboard.service;

import com.example.dashboard.entity.Bug;
import com.example.dashboard.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class BugService {
    @Value("${use.postgresql}")
    private boolean usePostgresql;

    @Autowired
    @Qualifier("csvDataRepository")
    private DataRepository csvDataRepository;

    @Autowired
    @Qualifier("postgresDataRepository")
    private DataRepository postgresDataRepository;

    private DataRepository getDataRepository() {
        return usePostgresql ? postgresDataRepository : csvDataRepository;
    }

    public List<Bug> getBugData() {
        if (usePostgresql) {
            return getDataRepository().getBugData();
        } else {
            return readBugFromCsv();
        }
    }

    private List<Bug> readBugFromCsv() {
        List<Bug> data = new ArrayList<>();
        try {
            ClassPathResource resource = new ClassPathResource("data/bug_progress.csv");
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()))) {
                String line;
                // Skip header
                reader.readLine();
                while ((line = reader.readLine()) != null) {
                    String[] values = line.split(",");
                    if (values.length >= 9) {  // 确保至少有9个字段
                        Bug bug = new Bug();
                        bug.setProgramName(values[0]);
                        bug.setTeamName(values[1]);
                        bug.setTotalBugs(Integer.parseInt(values[2]));
                        bug.setPreFixed(Integer.parseInt(values[3]));
                        bug.setUatFixed(Integer.parseInt(values[4]));
                        bug.setPrePending(Integer.parseInt(values[5]));
                        bug.setUatPending(Integer.parseInt(values[6]));
                        bug.setPreFixedRatio(Double.parseDouble(values[7]));
                        bug.setUatFixedRatio(Double.parseDouble(values[8]));
                        data.add(bug);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
} 