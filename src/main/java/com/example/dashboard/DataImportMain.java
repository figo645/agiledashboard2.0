package com.example.dashboard;

import com.example.dashboard.util.SimpleCsvImporter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DataImportMain {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java -jar your-app.jar <csv-file-path> <data-type>");
            System.out.println("Available data types:");
            System.out.println("- sprint_planning");
            System.out.println("- iteration_completion");
            System.out.println("- bug_progress");
            System.out.println("- change_tracking");
            System.out.println("- testing_progress");
            return;
        }

        // 启动 Spring Boot 应用
        ConfigurableApplicationContext context = SpringApplication.run(DataImportMain.class, args);
        
        // 获取 SimpleCsvImporter 实例
        SimpleCsvImporter importer = context.getBean(SimpleCsvImporter.class);
        
        try {
            // 执行数据导入
            System.out.println("Starting data import...");
            importer.importCsvData(args[0], args[1]);
            System.out.println("Data import completed successfully!");
        } catch (Exception e) {
            System.err.println("Error during data import: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // 关闭应用上下文
            context.close();
        }
    }
} 