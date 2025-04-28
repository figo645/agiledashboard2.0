package com.example.dashboard.controller;

import com.example.dashboard.util.SimpleCsvImporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

@RestController
@RequestMapping("/api/import")
public class DataImportController {

    @Autowired
    private SimpleCsvImporter csvImporter;

    @PostMapping("/{dataType}")
    public String importData(@PathVariable String dataType, @RequestParam("file") MultipartFile file) {
        try {
            // 创建临时文件
            Path tempFile = Files.createTempFile("import-", ".csv");
            Files.copy(file.getInputStream(), tempFile, StandardCopyOption.REPLACE_EXISTING);

            // 导入数据
            csvImporter.importCsvData(tempFile.toString(), dataType);

            // 删除临时文件
            Files.delete(tempFile);

            return "Data imported successfully!";
        } catch (Exception e) {
            return "Error importing data: " + e.getMessage();
        }
    }

    @GetMapping("/types")
    public String[] getAvailableDataTypes() {
        return new String[] {
            "sprint_planning",
            "iteration_completion",
            "bug_progress",
            "change_tracking",
            "testing_progress"
        };
    }
} 