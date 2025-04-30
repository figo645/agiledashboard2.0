package com.example.dashboard.service;

import com.example.dashboard.entity.TeamData;
import com.example.dashboard.entity.IterationCompletion;
import com.example.dashboard.entity.BugProgress;
import com.example.dashboard.entity.ChangeTracking;
import com.example.dashboard.entity.TestingProgress;
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
import java.time.LocalDate;

/**
 * 冲刺计划服务类。
 * 提供冲刺计划相关的数据查询和处理功能。
 */
@Service
public class SprintPlanningService {

    private final DataRepository dataRepository;
    private final String sprintPlanningCsvPath;

    /**
     * 构造函数，注入数据仓库依赖和配置。
     *
     * @param usePostgresql 是否使用 PostgreSQL 数据库
     * @param dataRepository 数据仓库接口
     */
    @Autowired
    public SprintPlanningService(@Value("${use.postgresql}") boolean usePostgresql,
                               @Qualifier("csvDataRepository") DataRepository csvDataRepository,
                               @Qualifier("postgresDataRepository") DataRepository postgresDataRepository,
                               @Value("${csv.sprint-planning}") String sprintPlanningCsvPath) {
        this.dataRepository = usePostgresql ? postgresDataRepository : csvDataRepository;
        this.sprintPlanningCsvPath = sprintPlanningCsvPath;
    }

    /**
     * 获取指定日期的冲刺计划数据。
     *
     * @param date 查询日期
     * @return 团队数据列表
     */
    public List<TeamData> getSprintPlanningData(LocalDate date) {
        if (dataRepository != null) {
            return dataRepository.getSprintPlanningData(date);
        }
        return readSprintPlanningFromCsv();
    }

    /**
     * 获取指定日期的迭代完成数据。
     *
     * @param date 查询日期
     * @return 迭代完成数据列表
     */
    public List<IterationCompletion> getIterationCompletionData(LocalDate date) {
        return dataRepository.getIterationCompletionData(date);
    }

    /**
     * 获取指定日期的缺陷进度数据。
     *
     * @param date 查询日期
     * @return 缺陷进度数据列表
     */
    public List<BugProgress> getBugProgressData(LocalDate date) {
        return dataRepository.getBugProgressData(date);
    }

    /**
     * 获取指定日期的变更跟踪数据。
     *
     * @param date 查询日期
     * @return 变更跟踪数据列表
     */
    public List<ChangeTracking> getChangeTrackingData(LocalDate date) {
        return dataRepository.getChangeTrackingData(date);
    }

    /**
     * 获取指定日期的测试进度数据。
     *
     * @param date 查询日期
     * @return 测试进度数据列表
     */
    public List<TestingProgress> getTestingProgressData(LocalDate date) {
        return dataRepository.getTestingProgressData(date);
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