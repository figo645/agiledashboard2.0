package com.example.dashboard;

import com.example.dashboard.util.SimpleCsvImporter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CsvImportApplication {

    public static void main(String[] args) {
        SpringApplication.run(CsvImportApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(SimpleCsvImporter importer) {
        return args -> {
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

            String csvFilePath = args[0];
            String dataType = args[1];

            try {
                importer.importCsvData(csvFilePath, dataType);
                System.out.println("Data imported successfully!");
            } catch (Exception e) {
                System.err.println("Error importing data: " + e.getMessage());
                e.printStackTrace();
            }
        };
    }
} 