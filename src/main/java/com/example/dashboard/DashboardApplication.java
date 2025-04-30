package com.example.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 冲刺看板应用程序主类。
 * 负责启动 Spring Boot 应用程序。
 */
@SpringBootApplication
public class DashboardApplication {
    /**
     * 应用程序入口点。
     *
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        SpringApplication.run(DashboardApplication.class, args);
    }
}