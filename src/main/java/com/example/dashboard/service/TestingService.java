package com.example.dashboard.service;

import com.example.dashboard.entity.TestingProgress;
import com.example.dashboard.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * 测试管理服务类。
 * 提供测试数据的查询和处理功能。
 */
@Service
public class TestingService {
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

    /**
     * 获取指定日期的测试进度数据。
     *
     * @param date 查询日期
     * @return 测试进度数据列表
     */
    public List<TestingProgress> getTestingProgressData(LocalDate date) {
        return getDataRepository().getTestingProgressData(date);
    }
} 