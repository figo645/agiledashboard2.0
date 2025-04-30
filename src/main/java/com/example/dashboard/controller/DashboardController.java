package com.example.dashboard.controller;

import com.example.dashboard.entity.TeamData;
import com.example.dashboard.entity.IterationCompletion;
import com.example.dashboard.entity.BugProgress;
import com.example.dashboard.entity.ChangeTracking;
import com.example.dashboard.entity.TestingProgress;
import com.example.dashboard.service.SprintPlanningService;
import com.example.dashboard.service.IterationCompletionService;
import com.example.dashboard.service.BugService;
import com.example.dashboard.service.ChangeService;
import com.example.dashboard.service.TestingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

/**
 * 冲刺看板控制器。
 * 提供 REST API 接口用于获取各种数据。
 */
@RestController
@RequestMapping("/api")
public class DashboardController {

    private final SprintPlanningService sprintPlanningService;

    /**
     * 构造函数，注入冲刺计划服务依赖。
     *
     * @param sprintPlanningService 冲刺计划服务
     */
    @Autowired
    public DashboardController(SprintPlanningService sprintPlanningService) {
        this.sprintPlanningService = sprintPlanningService;
    }

    /**
     * 获取冲刺计划数据。
     *
     * @param date 查询日期
     * @return 团队数据列表
     */
    @GetMapping("/sprint-planning")
    public List<TeamData> getSprintPlanningData(@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return sprintPlanningService.getSprintPlanningData(date);
    }

    /**
     * 获取迭代完成数据。
     *
     * @param date 查询日期
     * @return 迭代完成数据列表
     */
    @GetMapping("/iteration-completion")
    public List<IterationCompletion> getIterationCompletionData(@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return sprintPlanningService.getIterationCompletionData(date);
    }

    /**
     * 获取缺陷进度数据。
     *
     * @param date 查询日期
     * @return 缺陷进度数据列表
     */
    @GetMapping("/bug-progress")
    public List<BugProgress> getBugProgressData(@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return sprintPlanningService.getBugProgressData(date);
    }

    /**
     * 获取变更跟踪数据。
     *
     * @param date 查询日期
     * @return 变更跟踪数据列表
     */
    @GetMapping("/change-tracking")
    public List<ChangeTracking> getChangeTrackingData(@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return sprintPlanningService.getChangeTrackingData(date);
    }

    /**
     * 获取测试进度数据。
     *
     * @param date 查询日期
     * @return 测试进度数据列表
     */
    @GetMapping("/testing-progress")
    public List<TestingProgress> getTestingProgressData(@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return sprintPlanningService.getTestingProgressData(date);
    }
} 