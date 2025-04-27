package com.example.dashboard.service;

import com.example.dashboard.entity.Change;
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
public class ChangeService {
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

    public List<Change> getChangeData() {
        if (usePostgresql) {
            return getDataRepository().getChangeData();
        } else {
            return readChangeFromCsv();
        }
    }

    private List<Change> readChangeFromCsv() {
        List<Change> data = new ArrayList<>();
        try {
            ClassPathResource resource = new ClassPathResource("data/change_tracking.csv");
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()))) {
                String line;
                // Skip header
                reader.readLine();
                while ((line = reader.readLine()) != null) {
                    String[] values = line.split(",");
                    if (values.length >= 3) {  // 确保至少有3个字段
                        Change change = new Change();
                        change.setTeamName(values[0]);
                        change.setChangeTasks(Integer.parseInt(values[1]));
                        change.setChangePoints(Integer.parseInt(values[2]));
                        data.add(change);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
} 