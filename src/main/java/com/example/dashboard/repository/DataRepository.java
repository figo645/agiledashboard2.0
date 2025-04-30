package com.example.dashboard.repository;

import com.example.dashboard.entity.TeamData;
import com.example.dashboard.entity.IterationCompletion;
import com.example.dashboard.entity.BugProgress;
import com.example.dashboard.entity.ChangeTracking;
import com.example.dashboard.entity.TestingProgress;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

/**
 * 数据仓库接口。
 * 定义数据访问的通用方法。
 */
@Repository
@Qualifier("dataRepository")
public interface DataRepository {
    /**
     * 获取指定日期的冲刺计划数据。
     *
     * @param date 查询日期
     * @return 团队数据列表
     */
    List<TeamData> getSprintPlanningData(LocalDate date);

    /**
     * 获取指定日期的迭代完成数据。
     *
     * @param date 查询日期
     * @return 迭代完成数据列表
     */
    List<IterationCompletion> getIterationCompletionData(LocalDate date);

    /**
     * 获取指定日期的缺陷进度数据。
     *
     * @param date 查询日期
     * @return 缺陷进度数据列表
     */
    List<BugProgress> getBugProgressData(LocalDate date);

    /**
     * 获取指定日期的变更跟踪数据。
     *
     * @param date 查询日期
     * @return 变更跟踪数据列表
     */
    List<ChangeTracking> getChangeTrackingData(LocalDate date);

    /**
     * 获取指定日期的测试进度数据。
     *
     * @param date 查询日期
     * @return 测试进度数据列表
     */
    List<TestingProgress> getTestingProgressData(LocalDate date);
} 