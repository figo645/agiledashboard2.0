package com.example.dashboard.service;

import com.example.dashboard.entity.IterationCompletion;
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
public class IterationCompletionService {
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

    public List<IterationCompletion> getIterationCompletionData() {
        if (usePostgresql) {
            return getDataRepository().getIterationCompletionData();
        } else {
            return readIterationCompletionFromCsv();
        }
    }

    private List<IterationCompletion> readIterationCompletionFromCsv() {
        List<IterationCompletion> data = new ArrayList<>();
        try {
            ClassPathResource resource = new ClassPathResource("data/iteration_completion.csv");
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()))) {
                String line;
                // Skip header
                reader.readLine();
                while ((line = reader.readLine()) != null) {
                    String[] values = line.split(",");
                    if (values.length >= 6) {  // 确保至少有6个字段
                        IterationCompletion completion = new IterationCompletion();
                        completion.setId(values[0] + "_" + values[1]);  // programName_teamName as ID
                        completion.setProgramName(values[0]);
                        completion.setTeamName(values[1]);
                        completion.setPlannedProgress(Double.parseDouble(values[2]));
                        completion.setActualProgress(Double.parseDouble(values[3]));
                        completion.setStorypointPlanned(Double.parseDouble(values[4]));
                        completion.setStorypointCompleted(Double.parseDouble(values[5]));
                        data.add(completion);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
} 