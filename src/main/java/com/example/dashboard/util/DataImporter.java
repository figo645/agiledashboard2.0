package com.example.dashboard.util;

import com.example.dashboard.entity.TeamData;
import com.example.dashboard.entity.IterationCompletion;
import com.example.dashboard.entity.BugProgress;
import com.example.dashboard.entity.ChangeTracking;
import com.example.dashboard.entity.TestingProgress;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

public class DataImporter {
    private static final Logger logger = LoggerFactory.getLogger(DataImporter.class);
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    
    // 配置数据库连接
    private static final String DB_URL = "jdbc:postgresql://129.211.65.53:5432/sprint_dashboard";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "your_password";
    
    // 配置CSV文件路径
    private static final String BASE_PATH = "src/main/resources/data/";
    private static final String SPRINT_PLANNING_CSV = BASE_PATH + "sprint_planning.csv";
    private static final String ITERATION_COMPLETION_CSV = BASE_PATH + "iteration_completion.csv";
    private static final String BUG_PROGRESS_CSV = BASE_PATH + "bug_progress.csv";
    private static final String CHANGE_TRACKING_CSV = BASE_PATH + "change_tracking.csv";
    private static final String TESTING_PROGRESS_CSV = BASE_PATH + "testing_progress.csv";

    private final EntityManager entityManager;
    private LocalDate importDate = LocalDate.now(); // 默认使用当前日期
    private String defaultDateStr = "2025-04-28"; // 默认日期字符串

    public DataImporter() {
        Properties props = new Properties();
        props.put("jakarta.persistence.jdbc.driver", "org.postgresql.Driver");
        props.put("jakarta.persistence.jdbc.url", DB_URL);
        props.put("jakarta.persistence.jdbc.user", DB_USER);
        props.put("jakarta.persistence.jdbc.password", DB_PASSWORD);
        props.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        props.put("hibernate.hbm2ddl.auto", "update");
        props.put("hibernate.show_sql", "true");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("dashboard", props);
        this.entityManager = emf.createEntityManager();
    }

    public static void main(String[] args) {
        try {
            DataImporter importer = new DataImporter();
            
            // 设置导入日期
            importer.setImportDate(importer.defaultDateStr);
            
            // 清理现有数据
            importer.cleanupData();
            
            // 导入所有数据
            importer.importAllData();
            
            System.out.println("All data imported successfully");
        } catch (Exception e) {
            System.err.println("Import failed: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }

    private void cleanupData() {
        logger.info("Cleaning up existing data");
        try {
            entityManager.getTransaction().begin();
            
            // 删除所有表中的数据
            entityManager.createQuery("DELETE FROM TeamData").executeUpdate();
            entityManager.createQuery("DELETE FROM IterationCompletion").executeUpdate();
            entityManager.createQuery("DELETE FROM BugProgress").executeUpdate();
            entityManager.createQuery("DELETE FROM ChangeTracking").executeUpdate();
            entityManager.createQuery("DELETE FROM TestingProgress").executeUpdate();
            
            entityManager.getTransaction().commit();
            logger.info("Data cleanup completed");
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw e;
        }
    }

    public void importAllData() throws IOException, CsvValidationException {
        logger.info("Starting import of all data");
        
        importCsvData(SPRINT_PLANNING_CSV, "sprint_planning");
        importCsvData(ITERATION_COMPLETION_CSV, "iteration_completion");
        importCsvData(BUG_PROGRESS_CSV, "bug_progress");
        importCsvData(CHANGE_TRACKING_CSV, "change_tracking");
        importCsvData(TESTING_PROGRESS_CSV, "testing_progress");
        
        logger.info("All data import completed");
    }

    public void importCsvData(String csvFilePath, String type) throws IOException, CsvValidationException {
        logger.info("Starting import of {} data from {}", type, csvFilePath);
        
        try {
            entityManager.getTransaction().begin();
            
            try (CSVReader reader = new CSVReader(new FileReader(csvFilePath))) {
                String[] header = reader.readNext();
                logger.info("CSV header: {}", String.join(", ", header));
                
                String[] line;
                int lineNumber = 1;
                int successCount = 0;
                int errorCount = 0;
                
                while ((line = reader.readNext()) != null) {
                    lineNumber++;
                    try {
                        switch (type) {
                            case "sprint_planning":
                                importSprintPlanningData(line);
                                break;
                            case "iteration_completion":
                                importIterationCompletionData(line);
                                break;
                            case "bug_progress":
                                importBugProgressData(line);
                                break;
                            case "change_tracking":
                                importChangeTrackingData(line);
                                break;
                            case "testing_progress":
                                importTestingProgressData(line);
                                break;
                        }
                        successCount++;
                    } catch (Exception e) {
                        errorCount++;
                        logger.error("Error processing line {}: {}", lineNumber, e.getMessage());
                    }
                }
                logger.info("Import completed. Successfully processed {} records, {} errors", successCount, errorCount);
            }
            
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw e;
        }
    }

    private void importSprintPlanningData(String[] data) {
        if (data.length < 14) {
            throw new IllegalArgumentException("Invalid data format for sprint planning. Expected at least 14 columns");
        }
        
        TeamData teamData = new TeamData();
        teamData.setId(data[0] + "_" + data[1]);
        teamData.setProgramName(data[0]);
        teamData.setTeamName(data[1]);
        teamData.setPlannedCount(Double.parseDouble(data[2]));
        teamData.setCompletedCount(Double.parseDouble(data[3]));
        teamData.setStorypointPlanned(Double.parseDouble(data[4]));
        teamData.setStorypointCompleted(Double.parseDouble(data[5]));
        teamData.setTestPoints(Double.parseDouble(data[6]));
        teamData.setUserStoryPoints(Double.parseDouble(data[7]));
        teamData.setUserStoryRatio(Double.parseDouble(data[8]));
        teamData.setEnablerPoints(Double.parseDouble(data[9]));
        teamData.setEnablerRatio(Double.parseDouble(data[10]));
        teamData.setStoryThroughput(Double.parseDouble(data[11]));
        teamData.setCvValue(Double.parseDouble(data[12]));
        teamData.setStoryGranularity(Double.parseDouble(data[13]));
        
        // 设置日期相关字段
        teamData.setDataDate(importDate);
        teamData.setDataMonth(importDate.format(DateTimeFormatter.ofPattern("yyyy-MM")));
        teamData.setDataQuarter(getQuarter(importDate));
        
        entityManager.persist(teamData);
    }

    private void importIterationCompletionData(String[] data) {
        if (data.length < 6) {
            throw new IllegalArgumentException("Invalid data format for iteration completion. Expected at least 6 columns");
        }
        
        IterationCompletion completion = new IterationCompletion();
        completion.setId(data[0] + "_" + data[1]);
        completion.setProgramName(data[0]);
        completion.setTeamName(data[1]);
        completion.setPlannedProgress(Double.parseDouble(data[2]));
        completion.setActualProgress(Double.parseDouble(data[3]));
        completion.setStorypointPlanned(Double.parseDouble(data[4]));
        completion.setStorypointCompleted(Double.parseDouble(data[5]));
        
        // 设置日期相关字段
        completion.setDataDate(importDate);
        completion.setDataMonth(importDate.format(DateTimeFormatter.ofPattern("yyyy-MM")));
        completion.setDataQuarter(getQuarter(importDate));
        
        entityManager.persist(completion);
    }

    private void importBugProgressData(String[] data) {
        if (data.length < 9) {
            throw new IllegalArgumentException("Invalid data format for bug progress. Expected at least 9 columns");
        }
        
        BugProgress bugProgress = new BugProgress();
        bugProgress.setId(data[0] + "_" + data[1]);
        bugProgress.setProgramName(data[0]);
        bugProgress.setTeamName(data[1]);
        bugProgress.setTotalBugs(Integer.parseInt(data[2]));
        bugProgress.setPreFixed(Integer.parseInt(data[3]));
        bugProgress.setUatFixed(Integer.parseInt(data[4]));
        bugProgress.setPrePending(Integer.parseInt(data[5]));
        bugProgress.setUatPending(Integer.parseInt(data[6]));
        bugProgress.setPreFixedRatio(Double.parseDouble(data[7]));
        bugProgress.setUatFixedRatio(Double.parseDouble(data[8]));
        
        // 设置日期相关字段
        bugProgress.setDataDate(importDate);
        bugProgress.setDataMonth(importDate.format(DateTimeFormatter.ofPattern("yyyy-MM")));
        bugProgress.setDataQuarter(getQuarter(importDate));
        
        entityManager.persist(bugProgress);
    }

    private void importChangeTrackingData(String[] data) {
        if (data.length < 3) {
            throw new IllegalArgumentException("Invalid data format for change tracking. Expected at least 3 columns");
        }
        
        ChangeTracking changeTracking = new ChangeTracking();
        changeTracking.setId(data[0]);
        changeTracking.setTeamName(data[0]);
        changeTracking.setChangeTasks(Integer.parseInt(data[1]));
        changeTracking.setChangePoints(Integer.parseInt(data[2]));
        
        // 设置日期相关字段
        changeTracking.setDataDate(importDate);
        changeTracking.setDataMonth(importDate.format(DateTimeFormatter.ofPattern("yyyy-MM")));
        changeTracking.setDataQuarter(getQuarter(importDate));
        
        entityManager.persist(changeTracking);
    }

    private void importTestingProgressData(String[] data) {
        if (data.length < 5) {
            throw new IllegalArgumentException("Invalid data format for testing progress. Expected at least 5 columns");
        }
        
        TestingProgress testingProgress = new TestingProgress();
        testingProgress.setId(data[0]);
        testingProgress.setTeamName(data[0]);
        testingProgress.setTotalTestCases(Integer.parseInt(data[1]));
        testingProgress.setCompletedTestCases(Integer.parseInt(data[2]));
        testingProgress.setFailedTestCases(Integer.parseInt(data[3]));
        testingProgress.setBlockedTestCases(Integer.parseInt(data[4]));
        
        // 设置日期相关字段
        testingProgress.setDataDate(importDate);
        testingProgress.setDataMonth(importDate.format(DateTimeFormatter.ofPattern("yyyy-MM")));
        testingProgress.setDataQuarter(getQuarter(importDate));
        
        entityManager.persist(testingProgress);
    }

    private String getQuarter(LocalDate date) {
        int month = date.getMonthValue();
        int year = date.getYear();
        int quarter = (month - 1) / 3 + 1;
        return year + "Q" + quarter;
    }

    // 设置默认日期字符串
    public void setDefaultDateStr(String dateStr) {
        this.defaultDateStr = dateStr;
        if (dateStr != null && !dateStr.trim().isEmpty()) {
            this.importDate = LocalDate.parse(dateStr);
        } else {
            this.importDate = LocalDate.now();
        }
    }
    
    // 获取默认日期字符串
    public String getDefaultDateStr() {
        return this.defaultDateStr;
    }
    
    // 设置导入日期
    public void setImportDate(LocalDate date) {
        this.importDate = date;
    }
    
    // 获取导入日期
    public LocalDate getImportDate() {
        return this.importDate;
    }
    
    // 设置导入日期（字符串格式）
    public void setImportDate(String dateStr) {
        if (dateStr != null && !dateStr.trim().isEmpty()) {
            this.importDate = LocalDate.parse(dateStr);
        } else {
            this.importDate = LocalDate.now();
        }
    }
} 