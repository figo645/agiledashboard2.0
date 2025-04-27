package com.example.dashboard.service;

import com.example.dashboard.entity.Testing;
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
public class TestingService {
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

    public List<Testing> getTestingData() {
        if (usePostgresql) {
            return getDataRepository().getTestingData();
        } else {
            return readTestingFromCsv();
        }
    }

    private List<Testing> readTestingFromCsv() {
        List<Testing> data = new ArrayList<>();
        try {
            ClassPathResource resource = new ClassPathResource("data/testing_progress.csv");
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()))) {
                String line;
                // Skip header
                reader.readLine();
                while ((line = reader.readLine()) != null) {
                    String[] values = line.split(",");
                    if (values.length >= 5) {  // 确保至少有5个字段
                        Testing testing = new Testing();
                        testing.setTeamName(values[0]);
                        testing.setTotalTestCases(Integer.parseInt(values[1]));
                        testing.setCompletedTestCases(Integer.parseInt(values[2]));
                        testing.setFailedTestCases(Integer.parseInt(values[3]));
                        testing.setBlockedTestCases(Integer.parseInt(values[4]));
                        data.add(testing);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
} 