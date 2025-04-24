package com.example.dashboard.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "csv")
public class CsvConfig {
    private String baseDirectory;
    private Files files = new Files();

    public static class Files {
        private String bug;
        private String change;
        private String iteration;
        private String sprint;
        private String testing;

        // Getters and Setters
        public String getBug() {
            return bug;
        }

        public void setBug(String bug) {
            this.bug = bug;
        }

        public String getChange() {
            return change;
        }

        public void setChange(String change) {
            this.change = change;
        }

        public String getIteration() {
            return iteration;
        }

        public void setIteration(String iteration) {
            this.iteration = iteration;
        }

        public String getSprint() {
            return sprint;
        }

        public void setSprint(String sprint) {
            this.sprint = sprint;
        }

        public String getTesting() {
            return testing;
        }

        public void setTesting(String testing) {
            this.testing = testing;
        }
    }

    // Getters and Setters
    public String getBaseDirectory() {
        return baseDirectory;
    }

    public void setBaseDirectory(String baseDirectory) {
        this.baseDirectory = baseDirectory;
    }

    public Files getFiles() {
        return files;
    }

    public void setFiles(Files files) {
        this.files = files;
    }

    // Helper methods to get full paths
    public String getBugFilePath() {
        return files.getBug();
    }

    public String getChangeFilePath() {
        return files.getChange();
    }

    public String getIterationFilePath() {
        return files.getIteration();
    }

    public String getSprintFilePath() {
        return files.getSprint();
    }

    public String getTestingFilePath() {
        return files.getTesting();
    }
} 